package com.fengyunweather.app.util;

import android.text.TextUtils;

import com.fengyunweather.app.model.City;
import com.fengyunweather.app.model.County;
import com.fengyunweather.app.model.FengyunWeatherDB;
import com.fengyunweather.app.model.Province;

/**
 * Created by Kevin on 2015/10/26.
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据,一个界面最多只能请求一个省但是可以同时请求并显示多个城市
     */

    public synchronized static boolean handleProvincesResponse(FengyunWeatherDB fengyunWeatherDB,String response){
        if(!TextUtils.isEmpty(response)){
            String[] allProvinces=response.split(",");
            if(allProvinces!=null&&allProvinces.length>0){
                for(String p:allProvinces){
                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    fengyunWeatherDB.saveProvince(province);
                }
            }return true;
        }
        return false;
    }

    /**
     * 解析处理服务器返回的市级数据
     */
    public static boolean handleCitiesResponse(FengyunWeatherDB fengyunWeatherDB,String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            String[] allCities=response.split(",");
            if(allCities!=null&&allCities.length>0){
                for(String c:allCities){
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    fengyunWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */

    public static boolean handleCountiesResponse(FengyunWeatherDB fengyunWeatherDB,String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            String[] allcounties=response.split(",");
            if(allcounties!=null&&allcounties.length>0){
                for(String c:allcounties){
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    fengyunWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}



























