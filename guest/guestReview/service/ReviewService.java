package loveproject.guest.guestReview.service;

import loveproject.commonService.CommonService;
import loveproject.guest.dto.GuestDTO;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class ReviewService {

	public void cancelProc(Parent reviewForm) {
		CommonService.WindowClose(reviewForm);
	}
	public void reportProc(Parent reviewForm) {
		
		TextArea review = (TextArea)reviewForm.lookup("#review");
		String review1 = "";
		if(review.getText() != null) {
			review1 = review.getText();
			GuestDTO dto = new GuestDTO();
			dto.setBlackList(review1);
			CommonService.Msg("신고완료");
			CommonService.WindowClose(reviewForm);
		}
		
		
	}
	public void goodProc(Parent reviewForm) {
		TextArea review = (TextArea)reviewForm.lookup("#review");
		String review1 = "";
		if(review.getText() != null) {
			review1 = review.getText();
			GuestDTO dto = new GuestDTO();
			dto.setGood(review1);
			CommonService.Msg("좋아요");
			CommonService.WindowClose(reviewForm);
		}
	}
	
}
