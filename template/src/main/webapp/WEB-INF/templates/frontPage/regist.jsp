<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script src="./media/js/form-wizard.js"></script>
<script src="./media/js/jquery.validate.min.js"></script>
<script src="./media/js/jquery.bootstrap.wizard.min.js"></script>

<script src="./media/js/select2.min.js"></script>
<script src="./media/js/form-wizard.js"></script>
<script>
	$(function(){
		App.init();
		FormWizard.init();
	});
</script>
<div class="padding-center">
	<div class="span3">
		<div class="portlet box red">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>课程通知
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newCourse">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
		<div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>最新文章
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newArticle">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
		<div class="portlet box purple">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>最新资源
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newResource">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
		<div class="portlet box yellow">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>热门下载
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newDown">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
		<div class="portlet box green">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>热门下载
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newProject">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
		<div class="portlet box blue">
			<div class="portlet-title">
				<div class="caption">
					<i class="icon-cogs"></i>友情链接
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse"></a> <a
						href="#portlet-config" data-toggle="modal" class="config"></a> <a
						href="javascript:;" class="reload hidden-phone"></a> <a
						href="javascript:;" class="remove hidden-phone"></a>
				</div>
			</div>
			<div class="portlet-body" id="newLink">
				<p>
					<a href="#">Linux内存管理心得</a>
				</p>

			</div>
		</div>
	</div>
	<div class="span9">
		<div class="span12" style="display: none">
			<h3 class="page-title" style="dispaly: none;"></h3>
		</div>
		<div class="span12">
			<div class="portlet box blue" id="form_wizard_1">

				<div class="portlet-title">

					<div class="caption">
						<i class="icon-cogs"></i>用户注册--<span class="step-title">Step
							1 of 4</span>
					</div>

					<div class="tools">
						<a href="javascript:;" class="collapse"></a> <a
							href="#portlet-config" data-toggle="modal" class="config"></a> <a
							href="javascript:;" class="reload"></a> <a href="javascript:;"
							class="remove"></a>
					</div>
				</div>
				<div class="portlet-body form">
					<form action="/controller/user/userHandler.php?type=submit"
						method="post" class="form-horizontal" id="submit_form">
						<div class="form-wizard">
							<div class="navbar steps">
								<div class="navbar-inner">
									<ul class="row-fluid">
										<li class="span3"><a href="#tab1" data-toggle="tab"
											class="step active"> <span class="number">1</span> <span
												class="desc"><i class="icon-ok"></i>账户设置</span>
										</a></li>
										<li class="span3"><a href="#tab2" data-toggle="tab"
											class="step"> <span class="number">2</span> <span
												class="desc"><i class="icon-ok"></i>个人信息</span>
										</a></li>
										<li class="span3"><a href="#tab3" data-toggle="tab"
											class="step"> <span class="number">3</span> <span
												class="desc"><i class="icon-ok"></i> 认证信息</span>
										</a></li>
										<li class="span3"><a href="#tab4" data-toggle="tab"
											class="step"> <span class="number">4</span> <span
												class="desc"><i class="icon-ok"></i>信息确认</span>
										</a></li>
									</ul>
								</div>
							</div>
							<div id="bar" class="progress progress-success progress-striped">
								<div class="bar"></div>
							</div>
							<div class="tab-content">
								<div class="alert alert-error hide">

									<button class="close" data-dismiss="alert"></button>

									请务必仔细填写表单信息.

								</div>

								<div class="alert alert-success hide">

									<button class="close" data-dismiss="alert"></button>

									恭喜表单信息验证通过!

								</div>

								<div class="tab-pane active" id="tab1">

									<h3 class="block">请填写您的账户信息</h3>

									<div class="control-group">

										<label class="control-label">用户名<span class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="username" /> <span
												class="help-inline">取个响亮的登录用户名吧？</span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">密码<span class="required">*</span></label>

										<div class="controls">

											<input type="password" class="span6 m-wrap" name="password"
												id="submit_form_password" /> <span class="help-inline">输入合理的长度，确保安全。</span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">确认密码<span
											class="required">*</span></label>

										<div class="controls">

											<input type="password" class="span6 m-wrap" name="rpassword" />
											<span class="help-inline">确认您的密码信息。</span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">邮箱<span class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="email" /> <span
												class="help-inline">务必填写正确的邮箱，我们需要她。</span>

										</div>

									</div>

								</div>

								<div class="tab-pane" id="tab2">

									<h3 class="block">个人基本信息</h3>

									<div class="control-group">

										<label class="control-label">真实姓名<span
											class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="realname" /> <span
												class="help-inline">填写您的真实姓名！</span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">电话号码<span
											class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="phone" /> <span
												class="help-inline">填写您的电话号码</span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">性别<span class="required">*</span></label>
										<div class="controls">
											<label class="radio"> <input type="radio"
												name="gender" value="男" data-title="Male" /> 男
											</label>
											<div class="clearfix"></div>
											<label class="radio"> <input type="radio"
												name="gender" value="女" data-title="Female" /> 女
											</label>
											<div id="form_gender_error"></div>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">省份信息</label>
										<div class="controls">
											<select name="province" id="province_list" class="span6">
												<option value="">请选择省份</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">城市信息</label>
										<div class="controls">
											<select name="city" id="city_list" class="span6">
												<option value="">请选择城市</option>
											</select>
										</div>
									</div>
									<div class="control-group">

										<label class="control-label">地区信息</label>
										<div class="controls">
											<select name="area" id="area_list" class="span6">
												<option value="">请选择地区</option>
											</select>

										</div>

									</div>
									<div class="control-group">
										<label class="control-label">街道</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="street" /> <span
												class="help-inline">街道信息可选</span>
										</div>

									</div>
									<div class="control-group">

										<label class="control-label">个人说明</label>

										<div class="controls">
											<textarea class="span6 m-wrap" rows="3" name="remarks"></textarea>
										</div>
									</div>
								</div>
								<div class="tab-pane" id="tab3">

									<h3 class="block">请填写认证审核信息</h3>

									<div class="control-group">

										<label class="control-label">学号<span class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="studentid" />

											<span class="help-inline"></span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">所在学院<span
											class="required">*</span></label>

										<div class="controls">

											<input type="text" class="span6 m-wrap" name="collage" /> <span
												class="help-inline"></span>

										</div>

									</div>
									<div class="control-group">

										<label class="control-label">入学年月(MM/YYYY)<span
											class="required">*</span></label>

										<div class="controls">

											<input type="text" placeholder="MM" maxlength="2"
												class="m-wrap small" name="expiry_mm" /> <input type="text"
												placeholder="YYYY" maxlength="4" class="m-wrap small"
												name="expiry_yyyy" /> <span class="help-inline"></span>

										</div>

									</div>

								</div>

								<div class="tab-pane" id="tab4">

									<h3 class="block">确认您的信息</h3>

									<h4 class="form-section">账户信息</h4>

									<div class="control-group">

										<label class="control-label">用户名:</label>

										<div class="controls">

											<span class="text display-value" data-display="username"></span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">邮箱:</label>

										<div class="controls">

											<span class="text display-value" data-display="email"></span>

										</div>

									</div>

									<h4 class="form-section">个人信息</h4>

									<div class="control-group">

										<label class="control-label">真实姓名:</label>

										<div class="controls">

											<span class="text display-value" data-display="realname"></span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">性别:</label>

										<div class="controls">

											<span class="text display-value" data-display="gender"></span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">电话号码:</label>

										<div class="controls">

											<span class="text display-value" data-display="phone"></span>

										</div>

									</div>
									<div class="control-group">

										<label class="control-label">省份:</label>

										<div class="controls">

											<span class="text display-value" data-display="province"></span>

										</div>

									</div>


									<div class="control-group">

										<label class="control-label">所在城市:</label>

										<div class="controls">

											<span class="text display-value" data-display="province"></span>

										</div>

									</div>
									<div class="control-group">

										<label class="control-label">街道:</label>

										<div class="controls">

											<span class="text display-value" data-display="street"></span>

										</div>

									</div>


									<div class="control-group">

										<label class="control-label">个人说明:</label>

										<div class="controls">

											<span class="text display-value" data-display="remarks"></span>

										</div>

									</div>

									<h4 class="form-section">认证信息</h4>

									<div class="control-group">

										<label class="control-label">学号:</label>

										<div class="controls">

											<span class="text display-value" data-display="studentid"></span>

										</div>

									</div>

									<div class="control-group">

										<label class="control-label">所在学院:</label>

										<div class="controls">

											<span class="text display-value" data-display="collage"></span>

										</div>

									</div>
								</div>
							</div>
							<div class="form-actions clearfix">
								<a href="javascript:;" class="btn button-previous"> <i
									class="m-icon-swapleft"></i> 返回
								</a> <a href="javascript:;" class="btn blue button-next"> 继续 <i
									class="m-icon-swapright m-icon-white"></i>
								</a> <input type="submit" class="btn green button-submit"
									id="submit_button" name="submit" value="确认提交">
							</div>

						</div>
					</form>

				</div>
			</div>
		</div>

	</div>
</div>