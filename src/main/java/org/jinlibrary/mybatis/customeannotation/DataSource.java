/**
 * File：DataSource.java
 * Package：org.jinlibrary.mybatis.customeannotation
 * Author：jin
 * Date：2017年5月8日 下午5:23:20
 * Copyright (C) 2017-2017 房天下-版权所有
 */
package org.jinlibrary.mybatis.customeannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Description: DataSource
 * </p>
 *
 * @author jinshilei
 *         2017年5月8日
 * @version 1.0
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface DataSource {

}
