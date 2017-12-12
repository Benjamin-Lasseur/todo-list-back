package benjamin.todolistback.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import benjamin.todolistback.service.InitService;

@Component
public class InitListener {
	@Autowired
	private InitService init;
	
	@EventListener({ ContextRefreshedEvent.class })
	void contextRefreshedEvent() {
		init.init();
	}
}
