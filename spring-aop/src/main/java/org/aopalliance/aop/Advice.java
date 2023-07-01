/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aopalliance.aop;

/**
 * 定义的横切逻辑。在如下几个时机，可以进行执行：
 * 	Before ：在目标方便调用前执行通知。
 * 	After ：在目标方法完成后执行通知。
 * 	After Returning ： 在目标方法执行成功后，调用通知。
 * 	After Throwing ：在目标方法抛出异常后，执行通知。
 * 	Around ：在目标方法调用前后均可执行自定义逻。
 *
 * Tag interface for Advice. Implementations can be any type
 * of advice, such as Interceptors.
 *
 * @author Rod Johnson
 * @version $Id: Advice.java,v 1.1 2004/03/19 17:02:16 johnsonr Exp $
 */
public interface Advice {

}
