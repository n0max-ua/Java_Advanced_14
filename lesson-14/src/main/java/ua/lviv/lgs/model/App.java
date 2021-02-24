package ua.lviv.lgs.model;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Cart cart1 = new Cart("total1", "name1");
		Cart cart2 = new Cart("total2", "name2");

		Item item1 = new Item("item1");
		Item item2 = new Item("item2");
		Item item3 = new Item("item3");
		Item item4 = new Item("item4");
				
		cart1.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
		cart2.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
				
		session.persist(cart1);
		session.persist(cart2);
						
		transaction.commit();
		session.close();

	}

}
