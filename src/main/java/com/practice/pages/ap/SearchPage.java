package com.practice.pages.ap;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_query_top")
	private WebElement searchBox;

	@FindBy(name = "submit_search")
	private WebElement searchButton;

	@FindBy(xpath = " //ul[@class='product_list grid row']")
	private List<WebElement> itemList;

	public void enterSearchText(String searchText) {

		searchBox.clear();
		searchBox.sendKeys(searchText);
	}

	public void clickSearchButton() {
		searchButton.click();

	}

	public int getItemCount() {
		return itemList.size();

	}

	public Boolean isItemDisplayed(String productName) {
		return itemList.stream().anyMatch(pl -> pl.getText().toLowerCase().contains(productName.toLowerCase()));

	}

}
