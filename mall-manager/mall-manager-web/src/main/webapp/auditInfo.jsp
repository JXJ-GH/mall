<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>商家信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 商家信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>商家名称：</label>
        </div>
        <div class="field">
          <input type="text"  style="width:25%; float:left;" class="input" name="stitle" value="lanqiao" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>负责人：</label>
        </div>
        <div class="field">
          <input type="text" id="url1" name="slogo" class="input tips" style="width:25%; float:left;" value="韩一菲" data-toggle="hover" data-place="right" data-image=""  />
        </div>
      </div>
			 <div class="form-group">
			  <div class="label">
			    <label>手机：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" name="s_phone" style="width:25%; float:left;" value="111111111" />
			    <div class="tips"></div>
			  </div>
			</div>
			<div class="form-group">
			  <div class="label">
			    <label>电话：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" style="width:25%; float:left;" name="s_tel" value="000000000" />
			    <div class="tips"></div>
			  </div>
			</div>
			<div class="form-group" style="display:none;">
			  <div class="label">
			    <label>邮箱：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" style="width:25%; float:left;" name="s_400" value="2324632026" />
			    <div class="tips"></div>
			  </div>
			</div>
			
			<div class="form-group">
			  <div class="label">
			    <label>QQ：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" style="width:25%; float:left;" name="s_qq" value="22314513" />
			    <div class="tips"></div>
			  </div>
			</div>
			<div class="form-group" style="display:none">
			  <div class="label">
			    <label>QQ群：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" name="s_qqu" value="sdasd" />
			    <div class="tips"></div>
			  </div>
			</div>     
			<div class="form-group">
			  <div class="label">
			    <label>Email：</label>
			  </div>
			  <div class="field">
			    <input type="text" class="input" name="s_email" value="654146554" />
			    <div class="tips"></div>
			  </div>
			</div>
      <div class="form-group">
        <div class="label">
          <label>主要商品：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="surl" value="暗示过那时候" />
        </div>
      </div>
      <div class="form-group" style="display:none">
        <div class="label">
          <label>副加标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="sentitle" value="" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>地址：</label>
        </div>
        <div class="field">
          <textarea class="input" name="skeywords" style="height:80px"></textarea>
          <div class="tips"></div>
        </div>
      </div>
     
    
              
      <div class="form-group">
        <div class="label">
          <label>商家自我描述：</label>
        </div>
        <div class="field">
          <textarea name="scopyright" class="input" style="height:120px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit">同意</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>