/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.test.yly.event;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;

public class AnnotatedAsyncEventHandlerDemo {

    public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 1. 注册当前类作为 Configuration Class
		context.register(AnnotatedAsyncEventHandlerDemo.class);
		context.register(MySpringEventListener.class);

		// 2.启动 Spring 应用上下文
		context.refresh(); // 初始化 ApplicationEventMulticaster

		// 3. 发布自定义 Spring 事件
		context.publishEvent(new MySpringEvent("Hello,World"));

		// 4. 关闭 Spring 应用上下文（ContextClosedEvent）
		context.close();
    }


	@EventListener
	public void onEvent(MySpringEvent event) {
		System.out.printf("[线程 ： %s] onEvent方法监听到事件 : %s\n", Thread.currentThread().getName(), event);
	}


}
