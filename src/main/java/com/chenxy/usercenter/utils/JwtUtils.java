package com.chenxy.usercenter.utils;

import com.chenxy.usercenter.pojo.DO.UserDO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    public static final String SUBJECT = "userCenter";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周
//    public static final long EXPIRE = 5000;  //过期时间，毫秒，5秒（测试用）

    //秘钥
    public static final  String APPSECRET = "userCenterSecret";

    /**
     * 生成jwt token
     * @param userDO
     * @return
     */
    public static String getJwtToken(UserDO userDO){
        if(userDO == null || userDO.getId() == null || userDO.getUsername() == null
                || userDO.getUserCode()==null){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT) //对应头部
                .claim("id", userDO.getId())
                .claim("username", userDO.getUsername())
                .claim("userCode", userDO.getUserCode()) //对应负载，就是根据需求往加密串里加的用户信息
                .setIssuedAt(new Date()) //发行时间
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE)) //有效期
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();//对应签名，主要是把前面两部分进行加密
        return token;
    }

    /**
     * 解密校验jwt token
     * @param token
     * @return
     */
    public static Claims checkJwtToken(String token ){
        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return  claims;
        }catch (Exception e){}
        return null;
    }

}
