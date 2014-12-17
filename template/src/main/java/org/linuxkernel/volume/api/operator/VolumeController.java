package org.linuxkernel.volume.api.operator;
//package com.vmware.volume.api.operator;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.vmware.eucenablement.horizontoolset.av.api.pojo.AppStack;
//import com.vmware.eucenablement.horizontoolset.av.api.pojo.Computer;
//import com.vmware.eucenablement.horizontoolset.av.api.pojo.Massage;
//import com.vmware.eucenablement.horizontoolset.av.api.pojo.Type;
//import com.vmware.eucenablement.horizontoolset.av.api.pojo.User;
//import com.vmware.horizontoolset.Application;
//import com.vmware.horizontoolset.util.JsonUtil;
//import com.vmware.horizontoolset.util.SessionUtil;
//import com.vmware.horizontoolset.viewapi.operator.DesktopPool;
//import com.vmware.horizontoolset.viewapi.operator.Machine;
//import com.vmware.horizontoolset.viewapi.operator.ViewOperatorCached;
//
//@Controller
//public class VolumeController {
//
//	@RequestMapping(value = "/m2avLogin", method = RequestMethod.GET)
//	public synchronized String m2avLogin(Model model, HttpSession session) {
//		if (VolumeService.isVolumeService(session))
//			model.addAttribute("view", "m2avAttach");
//		else
//			model.addAttribute("view", "m2avLogin");
//		model.addAttribute("user", SessionUtil.getuser(session));
//		return Application.MAINPAGE;
//
//	}
//
//	@RequestMapping(value = "/m2avAttach_login", method = RequestMethod.GET)
//	public synchronized String m2avAttachLogin(Model model, HttpSession session, @RequestParam(value = "host", required = true) String server,
//			@RequestParam(value = "domain", required = true) String domain, @RequestParam(value = "name", required = true) String name,
//			@RequestParam(value = "password", required = true) String password) {
//		VolumeCache.login(session, server, domain, name, password);
//		return "redirect:/m2avAttach";
//
//	}
//
//	@RequestMapping(value = "/m2avAttach", method = RequestMethod.GET)
//	public synchronized String m2avAttach(Model model, HttpSession session) {
//		model.addAttribute("view", "m2avAttach");
//		model.addAttribute("user", SessionUtil.getuser(session));
//		return Application.MAINPAGE;
//	}
//
//	@RequestMapping(value = "listPools")
//	public synchronized void listPools(HttpServletResponse response, HttpSession session) {
//		ViewOperatorCached api = SessionUtil.getViewOperatorCached(session);
//		List<DesktopPool> pools = api.desktopPools.get();
//		List<String> names = new ArrayList<>(pools.size());
//		for (DesktopPool p : pools) {
//			names.add(p.getSummary().name);
//		}
//		try {
//			response.setHeader("Content-type", "text/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.javaToJson(names));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "listAppStacks")
//	public synchronized void listAppStacks(HttpServletResponse response, HttpSession session) {
//		// list appStacks
//		List<AppStack> appStacks = VolumeService.listAppStacks(session);
//		List<String> names = new ArrayList<>();
//		for (AppStack appStack : appStacks) {
//			names.add(appStack.name);
//		}
//		try {
//			response.setHeader("Content-type", "text/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.javaToJson(names));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "listTargets")
//	public synchronized void listTargets(HttpServletResponse response, HttpSession session, @RequestParam(value = "poolId", required = true) String poolId,
//			@RequestParam(value = "targetType", required = true) String targetType) {
//
//		ViewOperatorCached api = SessionUtil.getViewOperatorCached(session);
//
//		DesktopPool pool = api.getDesktopPool(poolId);
//		Object ret = null;
//		JTableData data = new JTableData();
//		if ("user".equalsIgnoreCase(targetType)) {
//			// list pool users
//			List<String> entitledUsers = pool.entitledUsers.get();
//
//			for (String u : entitledUsers) {
//				JTableRecord r = new JTableRecord();
//				r.desktop = u;
//				if (null == VolumeService.getUser(r.desktop, session)) {
//					r.status = "No Agent";
//					r.appStacks.add("N/A");
//				} else {
//					r.status = "Enable";
//					List<AppStack> appStacks = VolumeService.getAppStacks(r.desktop, Type.USER, session);
//					if (null != appStacks)
//						if (!appStacks.isEmpty())
//							for (AppStack appStack : appStacks)
//								r.appStacks.add(appStack.name);
//						else
//							r.appStacks.add("N/A");
//
//					else
//						r.appStacks.add("N/A");
//				}
//				data.Records.add(r);
//			}
//		} else {
//			// list pool computers
//			List<Machine> machines = pool.machines.get();
//			for (Machine m : machines) {
//				JTableRecord r = new JTableRecord();
//				String dns_name = m.getSummaryView().base.dnsName;
//				String dnsName = null;
//				if (dns_name.contains(".")) {
//					r.desktop = dns_name.substring(0, dns_name.indexOf('.'));
//					dnsName = dns_name.substring(0, dns_name.lastIndexOf('.'));
//				} else {
//					r.desktop = dns_name;
//					dnsName = dns_name;
//				}
//				if (null == VolumeService.getComputer(dnsName, session)) {
//					r.status = "No Agent";
//					r.appStacks.add("N/A");
//				} else {
//					r.status = "Enable";
//					List<AppStack> appStacks = VolumeService.getAppStacks(dnsName, Type.COMPUTER, session);
//					System.out.println(dnsName);
//					if (null != appStacks)
//						if (!appStacks.isEmpty())
//							for (AppStack appStack : appStacks)
//								r.appStacks.add(appStack.name);
//						else
//							r.appStacks.add("N/A");
//
//					else
//						r.appStacks.add("N/A");
//				}
//				data.Records.add(r);
//			}
//		}
//		data.TotalRecordCount = data.Records.size();
//
//		ret = data;
//		try {
//			response.setHeader("Content-type", "text/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.javaToJson(ret));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "assignment")
//	public void aissgnment(HttpServletResponse response, HttpSession session, @RequestParam(value = "appStack", required = true) String appStack,
//			@RequestParam(value = "poolId", required = true) String poolId, @RequestParam(value = "targetType", required = true) String targetType,
//			@RequestParam(value = "type", required = true) String real) {
//		ViewOperatorCached api = SessionUtil.getViewOperatorCached(session);
//		DesktopPool pool = api.getDesktopPool(poolId);
//		Object ret = null;
//		int total = 0;
//		int enable = 0;
//		int success = 0;
//		if ("user".equals(targetType)) {
//			// list pool users
//			List<String> entitledUsers = pool.entitledUsers.get();
//			if (null != entitledUsers && !entitledUsers.isEmpty())
//				total = entitledUsers.size();
//			List<String> list_names = new ArrayList<>();
//			for (String str_user : entitledUsers) {
//				String name = str_user.trim();
//				User user = VolumeService.getUser(name, session);
//				if (null != user) {
//					list_names.add(user.getDomainName());
//				}
//				if (list_names.isEmpty())
//					return;
//				enable = list_names.size();
//				Massage msg = VolumeService.assignmentUser(appStack, list_names, real, session);
//				if (null == msg) {
//					ret = msg;
//				} else {
//					if (null != msg.successes) {
//						String str_success = msg.successes.get(0);
//						success = Integer.parseInt(str_success.trim().split(" ")[1].trim());
//						msg.successes.set(0, "total:" + total + " Enable:" + enable + " Success:" + success);
//					}
//					ret = msg;
//				}
//			}
//		} else {
//			// list pool computers
//			List<Machine> machines = pool.machines.get();
//			if (null != machines && !machines.isEmpty())
//				total = machines.size();
//			List<String> list_names = new ArrayList<>();
//			for (Machine m : machines) {
//				String dns_name = m.getSummaryView().base.dnsName;
//				String name = null;
//				if (dns_name.contains(".")) {
//					name = dns_name.substring(0, dns_name.lastIndexOf('.')).toUpperCase();
//				} else {
//					name = m.getSummaryView().base.dnsName.toUpperCase();
//				}
//				Computer computer = VolumeService.getComputer(name.toUpperCase(), session);
//				if (null != computer)
//					list_names.add(computer.getDomainName());
//			}
//			if (list_names.isEmpty())
//				return;
//			enable = list_names.size();
//			Massage msg = VolumeService.assignmentComputer(appStack, list_names, real, session);
//
//			if (null == msg) {
//				ret = msg;
//			} else {
//				if (null != msg.successes) {
//					String str_success = msg.successes.get(0);
//					success = Integer.parseInt(str_success.trim().split(" ")[1].trim());
//					msg.successes.set(0, "total:" + total + " Enable:" + enable + " Success:" + success);
//					PoolStack.put(poolId.toLowerCase(), appStack);
//				}
//				ret = msg;
//			}
//		}
//		try {
//			response.setHeader("Content-type", "text/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.javaToJson(ret));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "unassignment")
//	public void unaissgnment(HttpServletResponse response, HttpSession session, @RequestParam(value = "appStack", required = true) String appStack,
//			@RequestParam(value = "poolId", required = true) String poolId, @RequestParam(value = "targetType", required = true) String targetType,
//			@RequestParam(value = "type", required = true) String real) {
//		ViewOperatorCached api = SessionUtil.getViewOperatorCached(session);
//		DesktopPool pool = api.getDesktopPool(poolId);
//		Object ret = null;
//		int total = 0;
//		int enable = 0;
//		int success = 0;
//		if ("user".equals(targetType)) {
//			// list pool users
//			List<String> entitledUsers = pool.entitledUsers.get();
//			List<String> list_names = new ArrayList<>();
//			for (String str_user : entitledUsers) {
//				String name = str_user.trim();
//				User user = VolumeService.getUser(name, session);
//				if (null != user) {
//					list_names.add(user.getDomainName());
//				}
//				if (list_names.isEmpty())
//					return;
//				Massage msg = VolumeService.unassignmentUser(appStack, list_names, real, session);
//				if (null == msg)
//					ret = msg;
//				else
//					ret = msg;
//			}
//
//		} else {
//			// list pool computers
//			List<Machine> machines = pool.machines.get();
//			total = machines.size();
//			List<String> list_names = new ArrayList<>();
//			for (Machine m : machines) {
//				String dns_name = m.getSummaryView().base.dnsName;
//				String name = null;
//				if (dns_name.contains(".")) {
//					name = dns_name.substring(0, dns_name.lastIndexOf('.')).toUpperCase();
//				} else {
//					name = m.getSummaryView().base.dnsName.toUpperCase();
//				}
//				Computer computer = VolumeService.getComputer(name.toUpperCase(), session);
//				if (null != computer)
//					list_names.add(computer.getDomainName());
//			}
//			if (list_names.isEmpty())
//				return;
//			enable = list_names.size();
//			Massage msg = VolumeService.unassignmentComputer(appStack, list_names, real, session);
//			if (null == msg) {
//				ret = msg;
//			} else {
//				if (null != msg.successes) {
//					String str_success = msg.successes.get(0);
//					success = Integer.parseInt(str_success.trim().split(" ")[1].trim());
//					msg.successes.set(0, "total:" + total + " Enable:" + enable + " Success:" + success);
//					PoolStack.delete(poolId.toLowerCase(), appStack);
//				}
//				ret = msg;
//			}
//		}
//		try {
//			response.setHeader("Content-type", "text/json;charset=UTF-8");
//			response.getWriter().write(JsonUtil.javaToJson(ret));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@RequestMapping(value = "/installedAppStack", method = RequestMethod.GET)
//	public void getAppStacks(HttpServletResponse response, @RequestParam(value = "poolId", required = true) String poolId) {
//
//		response.setHeader("Content-type", "text/json;charset=UTF-8");
//		try {
//			response.getWriter().write(JsonUtil.javaToJson(PoolStack.get(poolId.toLowerCase())));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
