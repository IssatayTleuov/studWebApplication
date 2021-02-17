package com.company.database;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RatingDaoTest {

    @Before
    public void setUpBefore() {
        System.out.println("before");
    }

    @After
    public void setUpAfter() {
        System.out.println("after");
    }

    @Test
    public void getAllRatingTest() {

        try {
            RatingDao ratingDao = new RatingDao();
            Assert.assertNotNull(ratingDao.getAllRating());
            System.out.println("getAllRating is not null!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
