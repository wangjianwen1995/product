import com.sxdl.sd.entity.SdInfoColumn;
import com.sxdl.sd.util.MatchBmAndMc;
import org.junit.jupiter.api.Test;

public class FASTTEST {
    @Test
    public void t() {
        //I21.004	急性广泛前壁心肌梗死              疾病
        //59.9901	输尿管支架置换术            手术
        //sdinfoid sdinfocolumn.name
        //CM_0_1_3_1 CM_0_1_3_2 CM_0_1_4_1 CM_0_1_4_2
        //   4          6           4           6
        String goal = "I21.004 急性广泛前壁心肌梗死";
        String jbm = "I21.004", jmc = "急性广泛前壁心肌梗死", sbm = "59.9901", smc = "输尿管支架置换术";
        System.out.println(MatchBmAndMc.matchBmAndMc(jbm, jmc, goal));
    }
    @Test
    public void testObject(){
        SdInfoColumn sc=new SdInfoColumn();
        sc.setName_zh("123");
        SdInfoColumn sc2=sc;
        sc2.setName_zh(null);
        System.out.println("原来的 "+sc);
        System.out.println("复制的 " +sc2);
    }
}
