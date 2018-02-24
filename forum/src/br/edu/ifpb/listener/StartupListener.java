package br.edu.ifpb.listener;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import br.edu.ifpb.bean.UtilBean;
import br.edu.ifpb.dao.PersistenceUtil;


/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(StartupListener.class);
    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
			if (emf != null) {
				emf.close();
				logger.info("Fábrica de EntityManagers fechada.");
			}
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	PersistenceUtil.createEntityManagerFactory("forum");
		logger.info("Fábrica de EntityManagers instanciada.");
		
		event.getServletContext().setAttribute("utilBean", new UtilBean());
    }
	
}
