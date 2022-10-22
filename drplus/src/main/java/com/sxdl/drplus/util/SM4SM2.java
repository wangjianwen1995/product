package com.sxdl.drplus.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class SM4SM2 {
    // key 我的私钥 , 用来解密平台返回过来的数据 (平台使用的我公钥加密数据,只能用我的私钥解密)
    public static final String MySM2privateKeyStr="308193020100301306072A8648CE3D020106082A811CCF5501822D0479307702010104203010D5A7F5C53DA8237DF760A6D3650880FFECD433596DF8F443A9006C9CDF6FA00A06082A811CCF5501822DA14403420004B1EB92442B9D1DB3F88550B8D15B1CACAD8895EB429C77008E2451E002317A49DCA46E589CACF813379BBADAF62CE6128C7B289D8957A4125761C7CBFC909D1C";
    //TODO 我的公钥 给平台让他们加密数据(到时候 给平台)
    public static final String MySM2publicKeyStr="3059301306072A8648CE3D020106082A811CCF5501822D03420004B1EB92442B9D1DB3F88550B8D15B1CACAD8895EB429C77008E2451E002317A49DCA46E589CACF813379BBADAF62CE6128C7B289D8957A4125761C7CBFC909D1C";
    //TODO  平台的 公钥 用来加密数据(到时候给平台要)
    public static final String PlatFormSM2publicKeyStr="3059301306072A8648CE3D020106082A811CCF5501822D03420004B1EB92442B9D1DB3F88550B8D15B1CACAD8895EB429C77008E2451E002317A49DCA46E589CACF813379BBADAF62CE6128C7B289D8957A4125761C7CBFC909D1C";


    static{
        Security.addProvider(new BouncyCastleProvider());
    }

/*
    public static void main(String[] args) throws  Exception  {

        String data = "{医院上报数据}";

        //1 生成 SM4 秘钥
        String sm4Key = SM4SM2.getSM4Key();

        //2 使用SM4 秘钥加密 input节点数据
        String input_data = SM4SM2.SM4EncryptStr(sm4Key, data);

        //3 使用SM2 将SM4的秘钥加密 放到 cainfo 节点中
        String cainfo_data = SM4SM2.SM2EncryptStr(sm4Key);

        //4 如果 需要获取 平台output 节点数据
        //4.1 SM2 解密 SM4中的秘钥
        sm4Key = SM4SM2.SM2DecryptStr(cainfo_data);

        //4.2 使用解密后的SM4秘钥 解密SM4 加密后的数据
        data = SM4SM2.SM4DecryptStr(sm4Key, input_data);

        System.out.println("其实很简单"+data);

    }   */


    //正式数据 测试
    public static  String cainfo =  "04035DF9B4C9AD184F0BC21CD0CDE62B9EEF4D6CE9B791E521506B0574ABAC7C244836E62C28FE46904620B24E33EE72A5E794DAB5E83A5A33F97178B39C87384293DFEEDA595CE58EA435FEC103D8DCA04BD7998DE02E1AF9C66FC887064BE7DB98B22E703509889E008D598019A81339561DD0D3BC3E82DCB794F3AF72E70F45";
    public static  String input= "073094b665070ca35edf33301d01ed4f76d032b2d04dc0f98c9f35c64750630b39248ef0ae67109c534a1cf2351db05a556def04b634bfc288d0fc7579ac5eb90471b67393a5cebca562c391a25eb50f27b9d781a49e7429ba0279d0b9812a45a7053dbbbc4d1272cccacf7d9a38184553e8bd089515fff95a0e79280f5370f45319637984533b6798c7b4ae8a15aa387f304af998a9bdf62588e531865df7b37dccd55c99b4b045dfee00a48228ec4d218e163bb6e55fa34e807dcfa103afce7b47396222a97713a71b166855112f0c955f4f08d9fd8535bb99d6898627dab1e0cfdadf0b3e74525674c599632a5689931b1aaf47a6a2aa1c22bce4a526bc7a2865489713aa47f93471723c631b0c77cd921236216f58d96e449ec776fe677b6e31c83bfe92ea4fa6d490576845fc99cea80674e444ac50c5ba0ede581ab8e2daa0b4ac48a24d466e689de95d368c72a378c99aa27790fb8e1db6c701f5a4a46268fc34ed011df256810e620f6a91db23e9a4f06456d2d33ec9833e86877afb960058e5aabecaf07ce07d5b3aa5b4867e1723cfdf3c904f6ccdea3e59865fb5f05520823c6e3ad96f3c850aa933dda3ea036de2c010e1f3d4275ae6878bc60b911f7bc1d006e5bd288f59fe253fe74fb86b4a2960aae97fca98aeba860b71c0e75e7eb8f11590afa8f7f3a94545ef48459c2dcbcf232eb371737e17eca8e7e2a752e8ecf409b994f218b4b2e8e6cdf3ab79023844ebcdc005a165bf5c4c78f1de9db0b4f9f18ebe8697c4ff066df574ae8f83f992e08d8b6ddfbb460359911b8c6d5fdab6b4ca851f19ac2a6414ba2cb3e67087bfb4fe8599391650e5063720f69d0aeb916c3cf2edd9f9ec7831250d3f9e87da835668efcf28049fd0a857612d068a868bd66f7a489c6a0ce2299fc13bbbed39186ea91b440a19e4c8efc2162c261e5da608d5d3cf6a1874133a00dbf69d0aeb916c3cf2edd9f9ec7831250d3f9e87da835668efcf28049fd0a85761e4c93e4e814088d120f4cb3fd04eb96d36a07f01e60a961f8fab2223b09779d34c92adec78baa5396fb06f1e8ffded131a0b6847cb8d7e12245956ac63cf6742ce527cb1ccfe025c5e95670297adc5e1a04ea11cdb60402e5e9118b10409a6a5aaca514c121becb6f1098ad57700857bfb04e6e529fc9d9494823afc61a486fa7ee58d69493d3159edbcde58b84c0a97be000a2609df2432f427b2be252388a27b9c427bbf821ddd5d972bfc54e8f62a5c94df06bfe5831e4ef55136c97b9199260b78f52a6566dd3f5a6e374aaff6a09840d0d5dc3986a4332e2aff6aa29e32355850ac862931dfbb2884847f70e330fb95cf22f42b915754ea937dcff27cbb40c4ed999864006ecb1fdb75f94eca623a7d3fa414782f70b234b7eb49cc2fd96f73d5b1f47f98667889b9571a6013a6aed6ff694482b6bb51b716f78e839e2a53af28306e4cf2b9578353b62a4d7e2d0599a7644febacf2f912b7546616258d7c143090a1dda85ba67f82876b2146dd0c853afc455717734ca4182affc6ab6e730236457049fe8a08d09ce67763a0b3f2fda6b32344d4e0795c05235752a55c4054d0278ef68afdfb94b47bf899f272c1606dff3a35803b7484cb5999fca2ef20bdeab19d46093dc6874a4acd115c28f834fb0281cefd28d7e2be3d42f429ed3f11aa0b244377e69b28bccf1016d525324f2df8dee836b43dd84aa498f2fe72f8abde495c625fc11462c90adfc693e83cb01dcde4be085a5604b7dfa0d0ebbf9c7a4739ab1cccf3137ccc3d51ea968c9f665f17347bb5abd210e9048f9654b761da5146bdba2b66dbd3604ab0c1e3fcdc2cedcb227a109992dc362b7c48ec34448c33c9d5e387884d2ee58168563cb0a844902085297eb60b21462ccda61e6a2b00030399a19e2f67c302dc99d65b8650864a939d558313bfc1479e13af743e9fad03abb6ca9c4a69c0f3b3771f5c639607732a120955a7205a26f3b22dbc6973a231d42eb6aea5ebd3b0b6d4d8df928281fb41f557025ca4ad3be92cdcce37333dbf380c033e299ff252066523b9d5b5e0c39ca92a423605d083be3f59439fee2f9aae3fd585bcb6f85ca460396d55fd5b04c1e7b5c695684ad7e12759ce3a55ac57a598968f72c5384ff3243e3d25c5097689d5becbe1611e919c00f5a321b229986aefe1ccb41860cb1d9e69690fcd9a59545a2bfc0a24edbe6410defcf617811a272797505d721e00b4e897cf4f73a231d42eb6aea5ebd3b0b6d4d8df92c18aff61281f18d565ca5d2e028353b2e8c30416583660036ea946d44c4d971a9ec185b787d5579048df2636fffc8031b6eee55b400c67ae7f31cbcf7b737b4d523f53be723d423e5010088dce6f320150017bab5257254cf0a68fcff7af8b05e381ed86f46df92ff0a56f71b21a8f2a24d5c81a85bd97f4f65a2287b6473d2bb93ab5c5cf4fd9e17149cbc9c04884b1a00a92d3d871593727371b130813ad9b879c24d953797c60233bf5d77070de17582c9917d553730a905b6bb6e5fd2e8836c259b702a88425f3cb7f51fb44aa31833458760241581894b57972fb223375302e13fe4b5813ffce92ac3b21d9f858eac98e5445c031bee750221497fd6db1f056506e9e70cfce692b60911f5173ccbc2bea8867474b95818e88a268ba299685d1a59f7db424ec5dd1363c637b02856668e78c3ff6d1e92d5afe7d823a4349c1e89e912ee5f6d12352a7904d3b5f6481541c0685c3a48aa478f7faee801fbd844da192c939cddfc89c633a8c070995cee2dfa62cf6e0647dccb1e24b5d6665d04890a34e1e1c46cad7f34064dbec342a94994d5e9c43900b1f461bf76d78cbb3c0e8d9490812db9318f70c225a68349e9b0273b102c58b1f9aea79a6ef0a34d2ea238bfd92896024856b3010109d55d176177cbea319e630f09d18ef979a15c814bdc34f39da24bc4b165a41e2fcf0750ddbd5e880f5538bc2ea4b1efc0f324307baacad225c25e1f9aead3521890c7c3e2957ec534b0cc07482cffef4143728f418b16160d332ac12eeb7e624df11a1405bd60c7bd14f2a7806520c405848c2e82842a5ca82ba9c093e2727fb22d305d6268ab1ed41decd848fc38f1f7ae63a1e98da880bea7d03e535444c82273209ef0b64ca9290d36603ecb5c87c3fc0064742160afe3b5d62a48436a6b6f07afb2636d1dcbe38153473bba5f724c50f55ef3f77aaf45d5990c90cc956f1ab29b3a00cda108a073b1fa16dd30ca87138166530608afb0b93688ded622b89e6ca95b25338e91163cc5c3204329f12fa8421656b415631cd56081fdf1fa689076118d51d8262d6405e5b5c57cbc5ed40842b403de9c4f4727d32be4a52570b9bc6e70eb75f6c1f8dd7220e00502908461781471a371893ca019f589013a4f2623aa3073dcd799a41a0268883247b71e3355b31a75f56a3aa08ad659af229156eacaf3c3a957ebc3f59f4cf811d50b5ae6eb9d7e217505324642473afc79a97513430076f20ecf9629f0294182b1cae88e4ea67d4c0433c2d2c51794bca59b620b57745fb5de79c008631fc3344556cc4a1837ef7f987911544ea5c68a4ae28363d054343e5e5f0108228c05048eff0b676efb258e248e615791368c26d303b1a0d446e03b3b71cecd5d06662ffcf5018b5221e8afef57d09a755d5cbf1cd37d612659321e3edf73c92f36e204cfd4baaed44c2ceae1f01d4b23fd121cab20e29e87662395fa2e6265628b4b2495bd2c7a3e7fc59434b8e82faee4afa853832173cecd2238ffe2e07f48a214259b8a88516216c5b1275356f61d503e575a904383e8d93ddefb54cb5f12ff370ac6672995d690281c437279bb7d1ed359335f91e9d88c256062c5aa42959790e5eec2c61e4a4cc200258d4151a8c7a7006e9e448797745fb5de79c008631fc3344556cc4a15a5e8b70b25dd8f26c18e132f8a4af564c828b22806bef1bcc0f7f475e9ea6ecf14b5753adc1c72cbd2e1234ae776922b1e79a8b7bf9de4c7af3ef05ebc6c7e29f59ce8346b101a746a10cc1cba6c6b27acf9598de63c83a6dcfafe7a59afd48371418ea6cc94992ff13a9011b21250ab79fffafe14370f7d6d60a3f7ed309bbcc81a2e65c621c6a04c7cad4c33e7712ed8f016b3909dea826680c99edb08937ce9f0d955279a0e3ec48811afaff37d62123a083588b7067c9e3692045a38e623590c4ffd7d8c5e93a870f70dae44c1bc0849b85739d939424236defc772ba1b68cda2e043abaa51e16687ada004214cd4f6a50991524e75d00a366cc04e3f03971820a6c83092b9afcaf90c3837e9b15b12e77a10168e1d1aa949eca84fd8cb499bfb105c1d238377c47254312b2fab5ca73596153d867ab0a4d8713a79377bd902ae727a1d8c90d6b09f7dcdff7e5f3f7331a1000e8b302cee4413154798a79af44bf8c6f9b53912e260102f223002c706f76a9fb1f644f50f44c11e12747c3a903e6bdcdf565701e42718efa1b17f998db1b10498b0ff593aac3c87c15771a29dd459e5902885996b874538b5c9216a40d76850ac08dd6733f7070d8141e4f61e21bd70216c8abde72cc60bcdfb0a75f20e706174972d3ae5f6513354b29bcd4785379c69e8ad560d14de40c124f1e13dd2974a382e8d4b7bff655941f4111a2e166f2a4480be433bd9692b9fee9579a682225be2262438fb7aa8819b8509ae4f6af0002fb2b211b81c258e49409c1e1026464768d60e8235a029e269e8d8c98011d4b8a010fd9251f4de4400d8806c3d649d07727aa62fc992ad215017d6ad6f6b6e66c9ea9d74164118123e0f93047384117ffb3c918b1d81b128a27968ea3b41f375f069b77142367bb6c1e791774935e66c7fee084e8daf8b14b670834a3df8bac5a07c091d2f3f63efb1c32d7318727315a11f7a38d2acee3438b23eaa9b884dccfe0e93673b74bfbe01a3b410d1d2f4c70ced23e404f596811cd67753ef2c0934e62b703b9b3af8ac0f0c5c7e14e4ee11f3736a63d530ea331d9cc4f77ec2b43be8da58aca649af03d930a5a8b89bf4d00ee4d0b2b6823ecc1d4fb99b59e25f4cc42c64f5f7b4acd4c237e38a7d9737e14a2a8031bf3c0439787a3acff3ed69effe2ef7b4d4be4b98039565d1db1586ac4b1fa01a5b8104402083ba4f43e77702987e287f25523ed9c84b1d33c398a93fdeb92115b26cac0200bf2849d5dd7d6a83f5f194cbd03a4fdbe71091ba8939002d01aefecd11ca39ece8ee82e22ba42f1805d6a9b1ecf8df8744f5a45738eb548e0a577c92888371b707a27864aa02b6e5dcf14445098bcdbfabbe34b871dc99bff5892d7dfc467bcb0ada612dcd668779dcf9223ad1f2b7893706fa3679e59751193ba532075feb56ab14a2cc95be8fb03d9fdd2c3e2c50f0323bc1be9c01703c1285a51eee5bf964176ed826785efe9d9a3b726444ccc5270a85f9025d7b308b3f40c33791b96fbe89b2c5de0856017318dc163d6361a36f5fe546e416110a6adb60d7834536bd48cb50f0d6bfcf3de57eaa25d967b6a5113896eba4f14fb56f2f8cd81eea3d87f19d744db82624cae5332fa2d6f06058f1e5103f8777a20ea51661978db0d1c375ace9bd43cf81a4ef1b29b9ac598d61b182e28ef464ccc4693e33dc98daf5ec8a2270d9ec98e4ea387be72ef2f142e6bf5b71d2a5efa127ef09eaf3d494d471a0e0b398ab45eb1922f10d0bca0385810cef1001c02edebcc61e6721baf5b1bfb3514f";

    public static void main(String[] args) throws  Exception  {


        String sm4Key = SM4SM2.SM2DecryptStr(cainfo);

        //4.2 使用解密后的SM4秘钥 解密SM4 加密后的数据
        String data = SM4SM2.SM4DecryptStr(sm4Key, input);

        System.out.println("其实很简单"+data);

    }


    /**
     * 使用平台的 公钥   加密数据给平台
     */
    public static String SM2EncryptStr(String data){
        SM2 sm2 = SmUtil.sm2(null,PlatFormSM2publicKeyStr);
        String encryptStr = sm2.encryptBcd(data, KeyType.PublicKey);
        return encryptStr;
    }


    /**
     *  这块 平台 公钥 也是平台私钥 给一个
     * @param data
     * @param key
     * @return
     */
    public static String SM2EncryptStr(String data,String key){
        SM2 sm2 = SmUtil.sm2(null,key);
        String encryptStr = sm2.encryptBcd(data, KeyType.PublicKey);
        return encryptStr;
    }

    /***
     * 使用我的私钥 解密平台加密后的数据
     * @param data
     * @return
     */
    public static String SM2DecryptStr(String data){
        SM2 sm2 = SmUtil.sm2(MySM2privateKeyStr,null);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(data, KeyType.PrivateKey));
        return decryptStr;
    }



    public static String SM2DecryptStr(String data,String key){
        SM2 sm2 = SmUtil.sm2(key,null);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(data, KeyType.PrivateKey));
        return decryptStr;
    }
    /**
     * 使用秘钥   加密数据
     */
    public static String SM4EncryptStr(String key,String data){
        SymmetricCrypto sm4 = SmUtil.sm4(HexStringToByte(key));
        String encryptStr = sm4.encryptHex(data);
        return encryptStr;
    }

    /**
     * 使用秘钥   解密数据
     */
    public static String SM4DecryptStr(String key,String data){
        SymmetricCrypto sm4 = SmUtil.sm4(HexStringToByte(key));
        String decryptStr = sm4.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
        return decryptStr;
    }




    public static void 总测试() throws Exception {
        String key = SM4SM2.getSM4Key();
        System.out.println("SM4生成key:"+key);
        String content = "我是要加密的字符串";
        SymmetricCrypto sm4 = SmUtil.sm4(HexStringToByte(key));
        //加密
        String encryptHex = sm4.encryptHex(content);
        //解密
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("SM4加密后:"+encryptHex);
        testSM2(key);
        System.out.println("SM4解密后:"+decryptStr);
    }


    public static void testSM4() throws Exception {
        String key = SM4SM2.getSM4Key();
        System.out.println("生成key:"+key);
        String content = "我是要加密的字符串";
        SymmetricCrypto sm4 = SmUtil.sm4(HexStringToByte(key));
        //加密
        String encryptHex = sm4.encryptHex(content);
        //解密
        String decryptStr = sm4.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println("加密后:"+encryptHex);
        System.out.println("解密后:"+decryptStr);
    }




    public static void testSM2(String sm4KeyStr) throws Exception {

        // 生成128 bit 的 公钥 和 私钥
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();
        String privateKeyStr = ByteToHexString(privateKey);
        String publicKeyStr = ByteToHexString(publicKey);
        System.out.println("privateKeyStr:"+privateKeyStr);
        System.out.println("publicKeyStr:"+publicKeyStr);

        SM2 sm2 = SmUtil.sm2(HexStringToByte(MySM2privateKeyStr), HexStringToByte(MySM2publicKeyStr));
        // 公钥加密，私钥解密
        String encryptStr = sm2.encryptBcd(sm4KeyStr, KeyType.PublicKey);
        String decryptStr = StrUtil.utf8Str(sm2.decryptFromBcd(encryptStr, KeyType.PrivateKey));
        System.out.println("SM2加密后:"+encryptStr);
        System.out.println("SM2解密后:"+decryptStr);
    }
    /**
     *  byte[] 转成  Hex(十六进制)
     */

    public static String ByteToHexString(byte[] bytes){
        String key = new String(Hex.encodeHex(bytes, false));
        return key;
    }

    /**
     *  Hex(十六进制) 转成 byte[]
     */
    public static byte[]  HexStringToByte(String str){
        byte[] keyData = ByteUtils.fromHexString(str);
        return keyData;
    }






    /**
     *  静态代码块出问题,使用这里
     * @return
     * @throws Exception
     */
    public static String getSM4KeyIf() throws Exception {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null){
            double version = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME).getVersion();
            System.out.println("自带jar包版本:"+version);
        }else{
            double version = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME).getVersion();
            System.out.println(version);
            Security.removeProvider(BouncyCastleProvider.PROVIDER_NAME);
            Security.addProvider(new BouncyCastleProvider());
            version = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME).getVersion();
            System.out.println("新加入jar包版本:"+version);
        }
        String key = getSM4Key();
        System.out.println(key + "-----生成key");
        return key;
    }


    /**
     *  随机生成 SM4 秘钥
     * @return
     * @throws Exception
     */
    public static String getSM4Key() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("SM4" );
        kg.init(128, new SecureRandom());
        byte[] encoded = kg.generateKey().getEncoded();
        String key = ByteToHexString(encoded);
        return key;
    }

    /**
     *  随机生成 SM2 秘钥对
     * @return
     * @throws Exception
     */
    public static Map<String,String> getSM2Key() {
        Map<String,String> map = new HashMap<>();
        //生成128 bit 的 公钥 和 私钥
        KeyPair pair = SecureUtil.generateKeyPair("SM2");
        byte[] privateKey = pair.getPrivate().getEncoded();
        byte[] publicKey = pair.getPublic().getEncoded();
        String privateKeyStr = ByteToHexString(privateKey);
        String publicKeyStr = ByteToHexString(publicKey);
        System.out.println("privateKeyStr:"+privateKeyStr);
        System.out.println("publicKeyStr:"+publicKeyStr);
        map.put("private",privateKeyStr);
        map.put("public",publicKeyStr);
        return map;
    }


}
