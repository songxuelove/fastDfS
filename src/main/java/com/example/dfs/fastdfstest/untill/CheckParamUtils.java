package com.example.dfs.fastdfstest.untill;


/**
 * <p><strong>检查参数工具类</strong></p>
 * <p>
 *     速度比BeanUtils快的多 <br>
 *     对象拷贝 常用与 DO DTO PO VO之间的相互拷贝 <br>
 *     相同字段名之间 将值进行拷贝 <br>
 * </p>
 * <li>
 * <p>
 *     <strong>示例1: 检查是否为空 (null 与 "")</strong> <br>
 *     boolean result = CheckParamUtils.isNullOrEmpty(param); <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例2: 检查是否不为空 (!null 与 !"")</strong> <br>
 *     boolean result = CheckParamUtils.isNotNullAndNotEmpty(param); <br>
 * </p>
 * </li>
 * @author wzk
 * @see Object
 * @since 10:27 2021/8/12
 **/
public class CheckParamUtils {

    private CheckParamUtils() {}
    
    /**
     * <p>
     *     <strong>示例1: 检查是否为空 (null 与 "")</strong> <br>
     *     boolean result = CheckParamUtils.isNullOrEmpty(param); <br>
     * </p>
     * boolean result = CheckParamUtils.isNullOrEmpty(param); <br>
     * @param param 检查对象
     * @return boolean 是否为空
     * @author wzk
     * @since 17:37 2021/5/10
    **/
    public static boolean isNullOrEmpty(Object param) {
        return null == param || "".equals(param.toString());
    }

    /**
     * <p>
     *     <strong>示例2: 检查是否不为空 (!null 与 !"")</strong> <br>
     *     boolean result = CheckParamUtils.isNotNullAndNotEmpty(param); <br>
     * </p>
     * @param param 检查对象
     * @return boolean 是否为空
     * @other
     * @author wzk
     * @since 17:41 2021/5/10
    **/
    public static boolean isNotNullAndNotEmpty(Object param) {
        return null != param
                        && !"".equals(param.toString())
                        && !"[]".equals(param.toString());
    }

}
