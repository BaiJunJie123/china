package com.ssm.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;








import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class WeiXinOrderQuery {
	public static void main(String[] args) throws FileNotFoundException {
		String data = "d344f1215458438e9d6d7affa3164272,9571b20d636e4072b8cc0ab0e6f0fbc4,63e16a8f0d1641559774108dda1b452a,3fd9a764778d4036830b63173815f26f,309dc93c820b48cd8d871ba9994c75d8,870d6779eba64c539f097b3b98a08d5c,c5709afae81d4887968890e99f573cb4,75a2a044c35d495788e431bb90c8eba9,639854d7d0784a639070e0eaec5d27da,26b239d21a6046e29cb1398150377f47,1046d4a7a542460291ba20b548b6d536,93fa04deae6a4383becf23e060ea1bca,df370f86477a4308bda07e1d4ea917c9,124a202f1cf1482d9cfb31eae0ff839a,ccb67762961e42e8963ccdf15f4e7844,04329585b67a4b51a70e649d60610ff4,6f8db9ec9d0a49159ef5cf052e540fa7,d68f5cae58b84487bc6b0ce1c05dd850,0dcf9c11a512497f810f5e3e19aaf374,080b5c5b83ba4b218fe7fd1382450f3d,6295655ab050492cb23fc479088258b1,f617b877513f410a8d1a1f599505a821,05711c88741c48aaa8b20934f5c086bd,7a42cb8be80c4cd6ab2babd5b4fb2faa,39e83d0b78804e1f9842bd7f0617fe36,6e42e7fcaf91488d81287e802d7580b0,2ebbf155872c47da89e62a774dc8693f,289f330b57f640dba4de0e8c27d7eb5e,2c77f3be0c5b460d8a7dc02cd005ff70,9a74a1ca98ea41f49db0d558ea7c9954,da74807f3f6f4d49ab95208bdd957e2c,8206becdfe50482884371ff89234109d,b0fdcb857d45461eb077fa9911cea567,95ca54dcadbc4c6db8fbd058ed27c5d5,7cc1e70b4c74425cb6adaf46a9ab935c,00c5547278ae404eacf97d6096e3a893,3394af6c0fa54f729ca179e900c804e2,56d8a501f10245cea2f756252f3dd453,9771633f5d404f9c8f1d7e8206b7ee61,e77ce0875a6845a3afe7c9a90f003b3e,0ec99c1c77504f199f08fb9dbe6866b3,17e6789a81fd40f99a9d48392ec2062c,20bcafad58c946a2b52ed3e8bcefb6b2,1eddab99e4ad4ada934b26d980f8b60b,68af65c7452b415eb6194078c119ecc2,a9e4e058addb457097c0f53b83520534,c68f07dc98c944c78abd4af10372964f,93f51ced09444a169ce3ef910466de8a,ed40a20885a2495a949700595ffb0115,3997b53578304925b79710cc1014132b,f7e5558b984749bc914f2fdccd5aef4e,c7932897b23745fd88d501856777cc76,8524ae47ddf04a3da877a1929517dde7,3fdce25b09504e7589a07f58cec43df4,8f19816d356d43a7a6c316007886f088,3ec6f80e39604780b721af51bac0b218,ce3b806ced064a22a7364edd430de93b,0dd56ce149f941f984f11911e7d35cb3,e4070826f70c42499e835b2e11321b9b,db3ba1ca649d496f869fc178f55517b9,328a54f7f4bc4becaf3d6ece6427ad11,3a60e2eac368490e80208028cfc32a26,93b2630d19d7441fa3f321273ac8194a,439c7b62ee764d979677c5ee23a99f34,9a437252b42a4abea84eaf62936feae4,6a3173deb6134a44bd6d50c5b8ad244e,42e5ab72077e4cccac8a68731e4ce634,4053ff4ce0c94a96bbb51559c8cf29d1,bead7c3595844464a1b2144417d72894,fb5e8381d3034ca696262202f8108678,2a2906aa03dc4d6f8cf4a9f84522e19d,dd07325405954691932d01090796cf8a,84de07c509804452b13ad935c0a9b07b,be7a5872fd0145de82d11a00d574cec4,b00f3945087643f1b18d81169d54b984,31812d82b7ed4ea8a823abea1a11f301,34954fead99a400898de95b6352520af,e7c3b656f69d4d59a60882aa7d80e171,681143e41daa4d55975ca091bac02141,fee66bfad3a14d2196062a403ff82a7c,d3024d3051f8408293880b8e032cd429,27120a2786d04452aeb47a52968a30a4,5d490c483ad4414391a62c22eda27bad,d11bc952e0594010afb03238cf5fe49f,640e185f0acc4184aba956e78f47703f,a9b8fa5bdb134510908660ebf7956ec4,51d70eadd2c64cd8aac973f5258c3211,ac758250c4a545898297875286cb894b,da616ddd6ec64068b4fc5212dbe9c6bf,82ae43532059461ba2d01a5de4a5d54f,9122a94e06784ad1a7e62b8fefed56ef,f276805d06af473382f7ca9032b60448,d4feffa95798422abb3ebfc15ec13860,602ab7d88aeb4b9f9266f706b1f96e35,8360134e8e8f4709a349d3a1430d4d3e,2aa0adce04194538a89b2cba0da8d434,70b2c85db9164bcbb121c22e8f678ee9,81b5724ab37c46d88c00ee9e64bf0726,257eadc4e3404c70b802c40df86874a4,0c77945c38df4011b9e24a0c6de61746,001010677390487a98ddd66acc34475d,5ab7d1b1156b4d7e96f242f8e819f8d7,9bb2b1a511e54928a211397ae2332aa8,9f09da6d8c5f43c680ddf802ca4b7559,202f98cd54b94496818636eb0a21bfad,fdf13d0d60d74109bcfec0ec7e74b354,354f87187f234ab1ab920557a3fd9616,ec47042cd6464a48bda79eeccf9893b7,c6eaf9cd854343a8a21d6452893bb603,a5aab60a08804e4cbd2872f245001db6,efbd4642f2e94150a29a25db947ee4fd,7c462e76c4974f1c8741cd4f50e376a1,52e0d1ece1a94151a00819be43f4e95a,4cfad64683c047dea38965d7f3f21ba9,ee886d6c1693467a8afa2adc6f53e52a,fc40fd78bca14bd39804331ed1f11a56,386bfc0efd6240ddacd243b42656b418,b32a2dac7974485c83d3fab9ba5a2680,44b3563676c643a09ab50d29055c37db,e028cdb9cfaf4e839132db6c2d77b1a2,de5b14e503a9410a82d664724e6df49d,c1e68184c9ad41b79d06cba1b5f16f48,2ddddce3a5264d9d9e5adfd3ff9bda46,377b37c9736a4f66be2ac6a30c2d3b9c,c42a70ee890143a9b8cfe6d3c481412f,f5741b29d21c4e1bb10dd209a0ed21d7,32255146ac084fdd9fd65b0f959422df,071b72a6d680455289cca8c9373fc74c,d6e8be31374c48f6a4163f66121b2d10,fe9bb28763c04ec69e3d3803670144ae,373250c199f34bf297f5777964f3285a,c4be17b87fab424f845a66599eed075c,9ee42480998548908d8a0f8fb7c13a7c,1c3fa6efde6c40fda8f5c57b98fce282,a7a6c697b3c74e7bab8d01a87f0eb102,96fa57ab9c2b4a8cbcf54f77ed336d5e,bc7d6610396f4b288c6d5f659a065021,c96225631bd142d69fcb19653672b23c,fbe3e58c98c742efb33356cfa27ec4e2,5515efe7f6c645a89f9c7f9491e1e455,b2441d5ba30240929077953840ed3013,c389f6db6c7644cfae7cb1c8ae4b0175,1b09185e353b4625b952b61a8017f253,6b3ea07badac4ec4bce1005f6933a3e1,a1f5e207b9074422acbc14eb6bd8ad6c,4f1f50fa5570403cb5ce663ef351cdcd,da50260954ae4d48af21dcb6512d02ff,ab24d6f685cc4b33a819f19dbeb020b4,678b5f4038144618ae04d333357dde9e,c416b1fa2e154c3db2b63a30f6a1a7f5,c8dabaa830504823aec1feafcea253de,7383f6b60e0049b592b4eb57ded2ac49,ba0ead30b4cb4785a08ee4e526c3172b,adab0b26d819457b8dce56b9d29e81cc,7aac90d5572d4e9082bcacf4d9e0c9fc,1aa9173eafb241d9b452267521ff0964,7a8e0cf04a984f728fad44a8337f73bd,3b0c0d8c0e0d43a1b2d362a55342bdba,3479283776914ad99dff5fa0ebcf11ab,70a431f493974732b9fc610a6fbd9d20,52217ca228b646e393977e8208b4608f,8e5a1696fd4345ca9dc45b67a08db70a,9965244e90eb4677a09d96faf6593842,a199cb1bf5db4b12a0324ae60663ff5a,17e9f0c911124baaa108ac666b29ef1a,3ec23a82cffa494ea0d61f6e56328d14,8ef5e736864046db883072ed715c4ef9,b53374d639f041a9ac35ccf165b4cd2a,88232513452d4059bb7483fbe9367d88,f1bd6504f98444b4b665669e718c6a80,23e5ff181f644894948fd7d05bcdd0ed,e2ceaecca4e4487384cdd7d52d7b30fc,44f6637d72af4b229d908b3098f1ab5b,ce146dc4886d479abb3afe0dcfffa945,d0b831c1aabf4230b10dd602f1555a93,5ce5942407174cccb65e5adbb9cc02da,3614a3fa81de4b32a8ab1ccbb163f97e,2d22a08f8bbb47caaf54a697c40684f8,ff9fbda0f911448ebe25278b3c5ba6d8,c895418df6fb4dd7823a515ebbe110da,07c91fcd011f4db3a91f371561d249cb,7cf4681a0e7945c99c8be3da27719d47,0c62befe66924668a7dc8e5b96c99c67,3f76effa5c4546e3b1461b85527afe7a,bb445a2eeabc4d6295df98e4340f9132,806635eb491f4e9c95e4e6b47798f6b7,fec9e13683654cc7be425f69cc73a6bc,1c493730bf324a3ca337d9092d36db14,e38b8a41d96b4a7285bd690638c9b138,94f9d4381eaf43f689460b067861bbff,21ab6d4b202f48c58dc634593486dbea,d06aeed0de1347699e3405965b716350,77460fe87bf24438b221ffee7c4590f6,937b6899940b4228b22619ed402eea61,ef172157022b48c0964d8ac4cca9da53,1b181dc465b84a17bb7e8e80e2a320cf,d38a024b1f3743689be8949eabe60276,428e9a1ad8fb48058b7a46a82eeee540,32e610e0c13240588326734b02aba4c6,52fe75ca6e3b411d93214c81764feefc,56acc42e15344540af482587767efb0e,084de4c9dbbc4645a62095ce7d492c94,d253662d25854beba6ac20c62837969a,e4a485ad42654963aa79e070888128e4,c740bd095d2d4f63a4c2f4746f655fff,e3769806e7a84f30bafdec207b942a61,5a46cc604733410f899e26202a7a1802,1717f191db2b4ab68fc9d535d1e43749,5960b93c31f6467197df18c680885073,8deb206566a94b6892e35046b11c38ed,89e66bc0e5ce44828ee95ce5cabbcb29,91ccbcd04ef34dbe98f14eea6cd031b0,552ca74a19214dd4896a8d3e8b40d2b2,39648c295cac4cc091a031ae6aca51f9,42b90472a6c241118473f832d4937a3b,8b55d7370ce14e57a900453e76c29352,6d3b5e78bcf240c7a2ced30e7b7bda84,70eeb37df7f04a898d7583447a754553,fafd9f8ba5d84207abc25c0165615d3f,7287e8f08f5949dcbfaa697ea5305dc8,cab8003d0ed740d89e1f2c016d38705f,8329290c41bf4c99891bb837bb8a082e,8172733979b448bbb28f7fe7df50f7f1,e81804be88a54fe4baf63015e5ac4091,f28e93e58d99461180e323ed6251f830,64e3671634af463692c34a3be674602b,94276b0cfcfa434cb9167a7164610ca7,4e097c58b47a44d4bbeecd24d91580a7,ae085e465d0f4e5486432aa6b3b0df56,f9716cede7694a29910c5a3823bcc139,81385ea856764f8f800925650f254010,e32b53ff4bc24aa4b9b45d3966a5ec79,8887b677140c4435833fd0690286511c,f0a6301d4c724145bfb4d038ffbc2a63,c72c96b89db047248aa76533a1f44d47,85a4d06f3b754124b09e3114e594f6a9,019bff11e9de40cbae97df004e13c33d,23d2087b2f6c4bf58ee4e74182295599,c028c8db1487459891dca8472917c03b,b8d20e159773448c8a7cc32171af1156,bb33a9695348488b9494e6bbec64456c,d38ee39b720a4c93869474dd94b0e11d,509a3a4fcd824bdfa83f1addc06dcd9e,e40986ea80aa4ffda9492ddc123fd3f6,c7bb09b0ad014066b2d817dc11d5d3a9,9663742d7d804cdc87768110d90e4f32,f7b5923ea7354baeb2ac2ed89e90b7ff,625a1a1a32c64291943b3b600e8c6ac3,7a3b3ddfaf894a3689b716ade407cde4,bbbd9fb0b7fc4316b701b4c32def453a,b87b9d4fbb464dfc9cea4073b91ee84f,b2be2b2ecf2a4559a7c37246644aa0c4,2d954fd9bdfb4d10aeb2e7c26181c636,a7d429efa98d43f390e511d2bf8f0438";
		//String data = "33dd5960e19f4f84a59a731807227ede";
 		String data2[] = data.split(",");
		PrintStream ps = new PrintStream("C:\\Users\\A\\Desktop\\dongbao1.txt");   
		System.setOut(ps);
		for(int i=0;i<data2.length;i++ ){
			String result = getWeiXinPayStatus(data2[i].trim());
//			String result = getWeiXinPayStatus("27cb4f38a858403f9bd885e92e202f3a");
		         
			if(result.contains("trade_state")){
				String type = result.substring(result.indexOf("\"trade_state\":"),result.indexOf("\"trade_state\":")+24);
				if(type.contains("SUCCESS")){
					System.out.println((i+1+"             ") + data2[i] + "    ::::" + type);
					//System.out.println(data2[i]);
			}
			}else{
				//System.out.println((i+1+"             ") + data2[i] + ": 未付款");
			}
			
		}
		
	}

	private static String getWeiXinPayStatus(String out_trade_no) {
		String reqUrl = "https://api.mch.weixin.qq.com/pay/orderquery";
		Map<String, String> map = new HashMap<>();
        String appid = "wx0a073be92a917ed3";
        String mch_id = "1494938712";
        String nonce_str = "201812030000006";
        String key = "huangfei08huanfgei99huangfei1234";
        map.put("appid",appid);
        map.put("mch_id",mch_id);
        map.put("nonce_str",nonce_str);
        map.put("out_trade_no",out_trade_no);
        String pam = "appid=" + appid + "&mch_id=" + mch_id + 
        		"&nonce_str=" + nonce_str + 
        		"&out_trade_no=" + out_trade_no + "&key=" + key;
        String sign = DigestUtils.md5Hex(pam).toUpperCase();
        map.put("sign",sign);
        String jsonStr = JSON.toJSONString(map);

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost=new HttpPost(reqUrl);
        httpPost.addHeader("Content-Type","application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(XmlJson.json2xml(jsonStr), Charset.forName("UTF-8")));
        
        try {
            HttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed:" + response.getStatusLine());
                return "error";
            }else{
                String resultStr = EntityUtils.toString(response.getEntity());
//                System.out.println("resultJSON:"+XmlJson.xml2json(resultStr));
                return XmlJson.xml2json(resultStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "2";
	}
	
}
	
	
	
	