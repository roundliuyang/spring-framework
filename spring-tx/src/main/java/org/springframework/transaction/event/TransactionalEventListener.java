/*
 * Copyright 2002-2017 the original author or authors.
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

package org.springframework.transaction.event;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;

/**
 * 自 SpringFramework4.2 之后，出现了一种能在事务动作发生前后注入监听器的机制。举几个应用场景的例子：
 * 执行完数据库操作后发送消息
 * 执行数据库操作之前记录日志
 * 业务逻辑出错时事务回滚之后发邮件警报
 * 类似于这种事务动作执行前后进行附加操作的问题，在SpringFramework4.2之后就可以通过 @TransactionalEventListener 注解来实现。
 * @TransactionalEventListener 可提供4种监听时机，来执行附加操作：
 * BEFORE_COMMIT：提交之前
 * AFTER_COMMIT：提交之后
 * AFTER_ROLLBACK：回滚之后
 * AFTER_COMPLETION：事务完成之后
 *
 *
 * An {@link EventListener} that is invoked according to a {@link TransactionPhase}.
 *
 * <p>If the event is not published within the boundaries of a managed transaction, the
 * event is discarded unless the {@link #fallbackExecution} flag is explicitly set. If a
 * transaction is running, the event is processed according to its {@code TransactionPhase}.
 *
 * <p>Adding {@link org.springframework.core.annotation.Order @Order} to your annotated
 * method allows you to prioritize that listener amongst other listeners running before
 * or after transaction completion.
 *
 * @author Stephane Nicoll
 * @author Sam Brannen
 * @since 4.2
 */


/*
	@TransactionalEventListener的使用方式简单Demo

	@Service
	public class DemoService {

		@Autowired
		private USerDao userDao;

		@Autowired
		private ApplicationEventPublisher applicationEventPublisher;

		@Transactional(rollbackFor = Exception.class)
		public void test() {
			// 执行清空用户的数据库操作
			userDao.deleteAll();

			// 使用事件广播器来广播 用户清除事件
			applicationEventPublisher.publishEvent(new UserCleanEvent());
		}
	}

	@Component
	class MyTransactionListener {

		@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
		private void onTestEvent(UserCleanEvent event) {
			System.out.println("UserCleanEvent detected ......");
		}

	}

	// 定义 用户清除事件，它需要继承ApplicationEvent
	class UserCleanEvent extends ApplicationEvent {

	}

 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
public @interface TransactionalEventListener {

	/**
	 * Phase to bind the handling of an event to.
	 * <p>The default phase is {@link TransactionPhase#AFTER_COMMIT}.
	 * <p>If no transaction is in progress, the event is not processed at
	 * all unless {@link #fallbackExecution} has been enabled explicitly.
	 */
	TransactionPhase phase() default TransactionPhase.AFTER_COMMIT;

	/**
	 * Whether the event should be processed if no transaction is running.
	 */
	boolean fallbackExecution() default false;

	/**
	 * Alias for {@link #classes}.
	 */
	@AliasFor(annotation = EventListener.class, attribute = "classes")
	Class<?>[] value() default {};

	/**
	 * The event classes that this listener handles.
	 * <p>If this attribute is specified with a single value, the annotated
	 * method may optionally accept a single parameter. However, if this
	 * attribute is specified with multiple values, the annotated method
	 * must <em>not</em> declare any parameters.
	 */
	@AliasFor(annotation = EventListener.class, attribute = "classes")
	Class<?>[] classes() default {};

	/**
	 * Spring Expression Language (SpEL) attribute used for making the event
	 * handling conditional.
	 * <p>The default is {@code ""}, meaning the event is always handled.
	 * @see EventListener#condition
	 */
	String condition() default "";

}
