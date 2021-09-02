package loveproject.guest.guestReview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loveproject.guest.guestReview.service.ReviewService;

public class ReviewController implements Initializable{
	private Parent reviewForm;
	private ReviewService reviewSvc;
	public void setReviewForm(Parent reviewForm) {
		this.reviewForm = reviewForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		reviewSvc = new ReviewService();
	}
	
	public void reportProc() {
		reviewSvc.reportProc(reviewForm);
	}
	public void cancelProc() {
		reviewSvc.cancelProc(reviewForm);
	}
	public void goodProc() {
		reviewSvc.goodProc(reviewForm);
	}


}
