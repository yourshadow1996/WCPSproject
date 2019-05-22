package com.tnpy.common.utils.encryption;

import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @Description: TODO
 * @Author: LLS
 * @Date: 2018/12/23 14:54
 */
public class Encryption {
    private String DefaultKey = "TianNengPY";
    /**
     * 加密
     *
     * @param content
     *            待加密内容
     * @param key
     *            加密的密钥
     * @return
     */
    public  String encrypt(String content,String key){
        if(StringUtils.isEmpty(key))
        {
            key = DefaultKey;
        }
        try{
            KeyGenerator kgen=KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(key.getBytes());
            kgen.init(128,secureRandom);
            SecretKey secretKey=kgen.generateKey();
            byte[] enCodeFormat=secretKey.getEncoded();
            SecretKeySpec secretKeySpec=new SecretKeySpec(enCodeFormat,"AES");
            Cipher cipher=Cipher.getInstance("AES");
            byte[] byteContent=content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);
            byte[] byteRresult=cipher.doFinal(byteContent);
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<byteRresult.length;i++){
                String hex=Integer.toHexString(byteRresult[i]&0xFF);
                if(hex.length()==1){
                    hex='0'+hex;
                }
                sb.append(hex.toUpperCase());
            }
            return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param content
     *            待解密内容
     * @param key
     *            解密的密钥
     * @return
     */
    public  String decrypt(String content,String key){
        if(content.length()<1)
            return null;
        if(StringUtils.isEmpty(key))
        {
            key = DefaultKey;
        }
        byte[] byteRresult=new byte[content.length()/2];
        for(int i=0;i<content.length()/2;i++){
            int high=Integer.parseInt(content.substring(i*2,i*2+1),16);
            int low=Integer.parseInt(content.substring(i*2+1,i*2+2),16);
            byteRresult[i]=(byte)(high*16+low);
        }
        try{
            KeyGenerator kgen= KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(key.getBytes());
            kgen.init(128,secureRandom);
            SecretKey secretKey=kgen.generateKey();
            byte[] enCodeFormat=secretKey.getEncoded();
            SecretKeySpec secretKeySpec=new SecretKeySpec(enCodeFormat,"AES");
            Cipher cipher= Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);
            byte[] result=cipher.doFinal(byteRresult);
            return new String(result);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
