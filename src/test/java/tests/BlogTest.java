package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class BlogTest extends BaseTest {

    @Test(description = "Open popular post page")
    public void openPopularPostPage() {
        loginPage
                .open()
                .loginWithValidData();
        blogPage.openBlogPage();
        String categoryName = blogPage.getTextFromPopularPostList();
        blogPage.clickFirstFromPopularPostList();

        assertEquals(categoryName, popularPostPage.getPostName(), "The text doesn't match");

    }

    @Test(description = "Open category page")
    public void openCategoryPage() {
        loginPage
                .open()
                .loginWithValidData();
        blogPage.openBlogPage();
        String categoryName = blogPage.getTextFromCategoriesList();
        blogPage.clickFirstFromCategoriesList();

        assertEquals(categoryName,categoryPage.getCategoryName(), "The text doesn't match");

    }
}