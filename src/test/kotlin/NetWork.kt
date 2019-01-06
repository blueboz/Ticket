import cn.boz.utils.network.HttpUtils
import cn.boz.utils.network.HttpUtilsImpl
import org.junit.Test

class  NetWork{
    @Test
    fun testGet(){
        val  params = mapOf("username" to "jay")
        val inst = HttpUtilsImpl.getINST()
        val rst = inst.get("http://www.baidu.com",params)
        println(rst)
    }

    @Test
    fun testPost(){
        val  params = mapOf("uuid" to "xzMch83mDhBPRPsCIJBcWTAeQgOTu_8_2YPU-eKj7AK80dXYXOuA4rNf8Ib6upwpnzk6sUSZqyaonx2","appid" to "otn")
        val inst = HttpUtilsImpl.getINST()
        val rst = inst.post("https://kyfw.12306.cn/passport/web/checkqr",params)
        println(rst)
    }

    @Test
    fun tryLoginLiangChengyun(){
        val loginUrl="https://xn--9kq677j3ki.app/auth/login";
        val checkinUrl="https://xn--9kq677j3ki.app/user/checkin";
        val params = mapOf("email" to "1173626291@qq.com", "passwd" to "1173626291", "code" to "")
        val inst = HttpUtilsImpl.getINST()
        val resp = inst.post(loginUrl, params)
        println(resp)
        val resp2 = inst.post(checkinUrl)
        println()
        println(resp2)
    }
}