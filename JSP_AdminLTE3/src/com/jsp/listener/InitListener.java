package com.jsp.listener;

import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.MemberDAO;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;

/**
 * Application Lifecycle Listener implementation class InitListenr
 *
 */
@WebListener
public class InitListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent ctxEvent) {
		String sqlSessionFactoryTyep = ctxEvent.getServletContext().getInitParameter("sqlSessionFactory");

		String memberDAOType = ctxEvent.getServletContext().getInitParameter("memberDAO");
		String boardDAOType = ctxEvent.getServletContext().getInitParameter("BoardDAO");

		try {
			SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) Class.forName(sqlSessionFactoryTyep)
					.newInstance();

			Class<?> cls = Class.forName(memberDAOType);

			Method setsqlSessionFactory = cls.getMethod("setSessionFactory", SqlSessionFactory.class);

			Object obj = cls.newInstance();

			setsqlSessionFactory.invoke(obj, sqlSessionFactory);

			MemberDAO memberDAO = (MemberDAO) obj;

			MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
			
			
			
			
			

			Class<?> cls2 = Class.forName(boardDAOType);

			Method setsqlSessionFactory2 = cls2.getMethod("setSessionFactory", SqlSessionFactory.class);

			Object obj2 = cls2.newInstance();

			setsqlSessionFactory2.invoke(obj2, sqlSessionFactory);

			BoardDAO boardDAO = (BoardDAO) obj2;

			BoardServiceImpl.getInstance().setBoardDAO(boardDAO);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
