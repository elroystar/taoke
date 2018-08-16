package com.derhede.taoke.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Package : com.hshc.payment.common.tools.reflect
 * 
 * @author HuaShengHaoChe -- jiayu
 *		   2018年5月7日 上午10:27:00
 *
 */
public class BeanMapUtil {

	/**
	 * 
	 * 
	 * @param type
	 * @param map
	 * @return
	 * @throws Exception 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:27:14
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Object convertMap2Bean(Class type, Map map) throws Exception {
		Object obj = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
			obj = type.newInstance(); // 创建 JavaBean 对象
			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来,这样当一个属性赋值失败的时候就不会影响其他属性赋值.
					Object value = map.get(propertyName);
					if (null == value)
						continue;
					Object[] args = new Object[1];
					Class propertyType = descriptor.getPropertyType();
					args[0] = getPropertyTypeObj(propertyType, value);
					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (Exception e) {
			// 解析错误时抛出服务器异常 记录日志
			throw new Exception("从map转换为bean时异常!", e);
		}
		return obj;
	}
	/**
	 * 
	 * 
	 * @param type
	 * @param map
	 * @return
	 * @throws Exception 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:27:24
	 */
	public static  <T> T  newConvertMap2Bean(Class<T>  type, Map<String,Object> map) throws Exception {
		T obj = null;
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
			obj = type.newInstance(); // 创建 JavaBean 对象
			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();

				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来,这样当一个属性赋值失败的时候就不会影响其他属性赋值.
					Object value = map.get(propertyName);
					if (null == value)
						continue;
					Object[] args = new Object[1];
					Class<?> propertyType = descriptor.getPropertyType();
					args[0] = getPropertyTypeObj(propertyType, value);
					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (Exception e) {
			// 解析错误时抛出服务器异常 记录日志
			throw new Exception("从map转换为bean时异常!", e);
		}
		return obj;
	}

	/**
	 * 
	 * 
	 * @param type
	 * @param map
	 * @return
	 * @throws Exception 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:27:33
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map forBeanProperty(Class type, Map map) throws Exception {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
			// 给 JavaBean 对象的属性赋值
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (map.containsKey(propertyName)) {
					// 下面一句可以 try 起来,这样当一个属性赋值失败的时候就不会影响其他属性赋值.
					Object value = map.get(propertyName);
					if (null == value)
						continue;
					Class propertyType = descriptor.getPropertyType();
					map.put(propertyName, getPropertyTypeObj(propertyType, value));
				}
			}
		} catch (Exception e) {
			// 解析错误时抛出服务器异常 记录日志
			throw new Exception("从map转换为bean属性时异常!", e);
		}
		return map;
	}

	/**
	 * 功能描述： 根据类型转
	 * 
	 * @param propertyType
	 * @param obj
	 * @return 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:27:47
	 */
	@SuppressWarnings("rawtypes")
	private static Object getPropertyTypeObj(Class propertyType, Object obj) {
		if (propertyType == String.class) {
			return obj.toString();
		} else if (propertyType == Long.class) {
			if (obj instanceof Long) {
				return (Long) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Long.valueOf(obj.toString());
		} else if (propertyType == Integer.class) {
			if (obj instanceof Integer) {
				return (Integer) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Integer.valueOf(obj.toString());
		} else if (propertyType == Character.class) {
			if (obj instanceof Character) {
				return (Character) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return (Character) obj;
		} else if (propertyType == byte[].class) {
			if (obj instanceof byte[]) {
				return (byte[]) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return (byte[]) obj;
		} else if (propertyType == Byte.class) {
			if (obj instanceof Byte) {
				return (Byte) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Byte.valueOf(obj.toString());
		} else if (propertyType == Short.class) {
			if (obj instanceof Short) {
				return (Short) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Short.valueOf(obj.toString());
		} else if (propertyType == java.math.BigInteger.class) {
			if (obj instanceof java.math.BigInteger) {
				return (java.math.BigInteger) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return new java.math.BigInteger(obj.toString());
		} else if (propertyType == java.math.BigDecimal.class) {
			if (obj instanceof java.math.BigDecimal) {
				return (java.math.BigDecimal) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return new java.math.BigDecimal(obj.toString());
		} else if (propertyType == Boolean.class) {
			if (obj instanceof Boolean) {
				return (Boolean) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Boolean.valueOf(obj.toString());
		} else if (propertyType == Float.class) {
			if (obj instanceof Float) {
				return (Float) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Float.valueOf(obj.toString());
		} else if (propertyType == Double.class) {
			if (obj instanceof Double) {
				return (Double) obj;
			}
			if ("".equals(obj)) {
				return null;
			}
			return Double.valueOf(obj.toString());
		} else if (propertyType == Timestamp.class) {
			if (obj instanceof Timestamp) {
				return (Timestamp) obj;
			}
			String s = obj.toString();
			int dividingSpace = s.indexOf(' ');
			// 日期中没有时间进行补齐操作
			if (dividingSpace <= 0) {
				s += " 00:00:00";
			}
			return Timestamp.valueOf(s);
		} else if (propertyType == Date.class) {
			if (obj instanceof Date) {
				return (Date) obj;
			}
			String s = obj.toString();
			int dividingSpace = s.indexOf(' ');
			// 日期中没有时间进行补齐操作
			if (dividingSpace <= 0) {
				s += " 00:00:00";
			}
			return DateUtil.StringToDate(s, "yyyy-MM-dd hh:mm:ss");
		} else if (propertyType == java.sql.Time.class) {
			if (obj instanceof java.sql.Time) {
				return (java.sql.Time) obj;
			}
			String s = obj.toString();
			int dividingSpace = s.indexOf(' ');
			// 日期中没有时间进行补齐操作
			if (dividingSpace <= 0) {
				s += " 00:00:00";
			}
			return java.sql.Time.valueOf(s);
		}
		return null;
	}

	/**
	 * 将一个 JavaBean 对象转化为一个 Map
	 * 
	 * @param bean
	 * @return
	 * @throws Exception 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:28:04
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map convertBean2Map(Object bean) throws Exception {
		Map returnMap = null;
		try {
			Class type = bean.getClass();
			returnMap = new HashMap();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptors.length; i++) {
				PropertyDescriptor descriptor = propertyDescriptors[i];
				String propertyName = descriptor.getName();
				if (!propertyName.equalsIgnoreCase("class")) {
					Method readMethod = descriptor.getReadMethod();
					Object result = readMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(propertyName, result);
					} else {
						returnMap.put(propertyName, "");
					}
				}
			}
		} catch (Exception e) {
			// 解析错误时抛出服务器异常 记录日志
			throw new Exception("从bean转换为map时异常!", e);
		}
		return returnMap;
	}

	/**
	 * 根据getter方法转换bean为map
	 * 
	 * @param bean
	 * @return
	 * @throws Exception 
	 * @author HuaShengHaoChe -- jiayu
	 *	       2018年5月7日 上午10:28:15
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map convertBean2MapByGetter(Object bean) throws Exception {
		Map returnMap = null;
		try {
			Class type = bean.getClass();
			returnMap = new HashMap();
			if (bean instanceof Map) {
				// Map map = (Map)bean;
				// Set<Map.Entry<String, Object>> keySet = map.entrySet();
				// for(Map.Entry<String, Object> entry : keySet) {
				// returnMap.put(entry.getKey(), entry.getValue());
				// }
				// //如果是map直接返回
				// return returnMap;
				return (HashMap) bean;
			}

			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
			for (int i = 0; i < methodDescriptors.length; i++) {
				MethodDescriptor methodDescriptor = methodDescriptors[i];
				String methodName = methodDescriptor.getName();
				Class[] paramTypes = methodDescriptor.getMethod().getParameterTypes();
				String fieldName = "";
				if (!methodName.equals("getClass") && methodName.startsWith("get") && (paramTypes == null || paramTypes.length == 0)) {
					// System.out.println("methodName is: " + methodName);
					fieldName = StringUtil.firstToLower(methodName.substring(3, methodName.length()));
					Method getMethod = methodDescriptor.getMethod();
					Object result = getMethod.invoke(bean, new Object[0]);
					if (result != null) {
						returnMap.put(fieldName, result);
					} else {
						returnMap.put(fieldName, "");
					}
				}
			}
		} catch (Exception e) {
			// 解析错误时抛出服务器异常 记录日志
			throw new Exception("从bean转换为map时异常!", e);
		}
		return returnMap;
	}

	public static void main(String[] args) {

		Object object = getPropertyTypeObj(Boolean.class, true);
		System.out.print(object);
	}

}
