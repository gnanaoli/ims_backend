package com.fa.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.inventory.entity.Notifications;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

	List<Notifications> findByRequestedToAndNotificationStatus(String name, String new1);

	@Query(value = "SELECT n.* FROM notifications n,requestTo rt,notificationstatus ns where n.requestTo = c.id and c.id = sc.category_id order by ns.id desc", nativeQuery = true)
	List<Notifications> GetAllNotification();

	List<Notifications> findByRequestedFromAndNotificationStatusAndRequestedTo(String name, String new1,
			String everyone);

	List<Notifications> findByRequestedToAndNotificationStatusAndStatus(String wareHouseName, String new1,
			String itemReceived);

	List<Notifications> findByStatus(String string);

	
	@Query(value = "select no.* from notification_status no  where  no.requested_to=?1 and no.notification_status='NEW' order by no.id desc" , nativeQuery = true)
	List<Notifications> getCountNotifications(String requested_to);

	List<Notifications> findByRequestedFromAndNotificationStatus(String name, String new1);

	List<Notifications> findAllByOrderByIdDesc();	
	
	
}
