import cn.boz.utils.network.HttpUtils
import cn.boz.utils.network.HttpUtilsImpl
import org.junit.Test

class  NetWork{
    @Test
    fun test(){
        val  params = mapOf("username" to "jay")
        val inst = HttpUtilsImpl.getINST()
        val rst = inst.get("http://www.baidu.com",params)
        println(rst)
    }
}