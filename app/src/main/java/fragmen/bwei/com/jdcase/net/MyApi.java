package fragmen.bwei.com.jdcase.net;

import java.util.Map;

import fragmen.bwei.com.jdcase.bean.BannerBean;
import fragmen.bwei.com.jdcase.bean.BaseBeanTwo;
import fragmen.bwei.com.jdcase.bean.Classify2Bean;
import fragmen.bwei.com.jdcase.bean.ClassifyBean;
import fragmen.bwei.com.jdcase.bean.GoodsCarBean;
import fragmen.bwei.com.jdcase.bean.LoginBean;
import fragmen.bwei.com.jdcase.bean.RemBean;
import fragmen.bwei.com.jdcase.bean.SearchBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by kang on 2017/12/9.
 */

public interface MyApi {
    @GET("product/{id}")
Observable<ClassifyBean> list(@Path("id") String name);
    @GET("product/getProductCatagory")
    Observable<Classify2Bean> list2(@Query("cid") String param);
    //轮播
    @GET("ad/{id}")
    Observable<BannerBean> bannerList(@Path("id") String name);
    //查询展示
    @GET("product/searchProducts")
    Observable<SearchBean> searchList(@QueryMap Map<String,String> params);
    //http://120.27.23.105/product/searchProducts?keywords=笔记本&page=1
    //product/getProductDetail详情页
    @GET("product/getProductDetail")
    Observable<RemBean> rembean(@QueryMap Map<String,String> Map);
    //添加购物车product/addCart
    @GET("product/addCart")
    Observable<BaseBeanTwo> Login_re(@QueryMap Map<String ,String> param);
    //查询购物车http://120.27.23.105/product/getCarts?uid=4757
    @GET("product/getCarts")
    Observable<GoodsCarBean> goodsBean(@Query("uid") String uid);


}
