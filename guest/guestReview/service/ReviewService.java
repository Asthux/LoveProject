package loveproject.guest.guestReview.service;

import loveproject.commonService.CommonService;
import javafx.scene.Parent;
public class ReviewService {

	public void reportProc(Parent reviewForm) {
	}

	public void cancelProc(Parent reviewForm) {
		CommonService.WindowClose(reviewForm);
	}
}
