package com.tnpy.common.config.cors;

import com.alibaba.fastjson.JSONObject;
import com.tnpy.common.utils.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    //@Autowired
   // private com.tnpy.wcpsproject.mapper.mysql.TokenMapper TokenMapper;


    //提供查询
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {}
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {}
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
        if("OPTIONS" .equals(request.getMethod()))
        {
            return true;
        }
        /* //添加用户接口调用日志
        try
        {
            Token tokenAPILog = null;
            try
            {
                String tokenStr = request.getHeader("Token");
                tokenAPILog=(Token) JSONObject.toJavaObject(JSONObject.parseObject(tokenStr), Token.class);
            }
            catch (Exception ex)
            {

            }
            ApiCallRecord apiCallRecord = new ApiCallRecord();
            apiCallRecord.setApiroute(request.getRequestURI());
            apiCallRecord.setCalltime(new Date());
            apiCallRecord.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
            String apiParam = request.getQueryString();
            apiCallRecord.setLoginip(request.getRemoteAddr());
            Enumeration<String> paramNames = request.getParameterNames();//获取所有的参数名
            while (paramNames.hasMoreElements()) {
                String name = paramNames.nextElement();//得到参数名
                String value = request.getParameter(name);//通过参数名获取对应的值
                apiParam += " " + name+ "=" +value ;
            }
            apiCallRecord.setParams(apiParam);
            if(tokenAPILog != null)
            {
                apiCallRecord.setUserid(tokenAPILog.getUserid());
            }
            apiCallRecordMapper.insertSelective(apiCallRecord);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
*/

        //普通路径放行
        if (true || "/api/login".equals(request.getRequestURI()) || "/api/downloadFile".equals(request.getRequestURI())) {
            return true;}

        //权限路径拦截
        final String headerToken = request.getHeader("token");
        //判断请求信息
        if(null==headerToken||headerToken.trim().equals("")){
//            resultWriter.write("你没有token,需要登录");
//            resultWriter.flush();
//            resultWriter.close();
            return false;
        }


        //解析Token信息
        try {
            String tokenStr = request.getHeader("Token");
            Token token=(Token) JSONObject.toJavaObject(JSONObject.parseObject(tokenStr), Token.class);
            //根据客户Token查找数据库Token

           /* Token myToken=TokenMapper.findByUserId(token.getUserid() );
            //数据库没有Token记录
            if(null==myToken) {
//               resultWriter.write("我没有你的token？,需要登录");
//                resultWriter.flush();
//                resultWriter.close();
                return false;
            }
            //数据库Token与客户Token比较
            if( !token.getToken().equals(myToken.getToken()) ){
//               resultWriter.write("你的token修改过？,需要登录");
//                resultWriter.flush();
//                resultWriter.close();
                return false;
            }
            //判断Token过期
*/
            if(System.currentTimeMillis() - token.getBuildtime()>60*60*24*3){
//                resultWriter.write("你的token过期了？,需要登录");
//                resultWriter.flush();
//                resultWriter.close();
          //      return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
//            resultWriter.write("反正token不对,需要登录");
//            resultWriter.flush();
//            resultWriter.close();
            return false;
        }
        //最后才放行
        return true;
    }
}