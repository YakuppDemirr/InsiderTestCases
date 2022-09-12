package com.insider;

import org.testng.annotations.*;

import static com.insider.method.CreateMethodPage.*;
import static com.insider.method.DeleteMethodPage.*;
import static com.insider.method.ReadMethodPage.*;
import static com.insider.method.UpdateMethodPage.*;
import static com.insider.base.BasePage.*;
public class InsiderApiTest {

    @Test
    public static void checkPetEndpoints(){
        postPetMethod();
        logger.info("*** Create islemi tamamlandi. ***");
        getPetMethod();
        logger.info("*** Create edilen pet icin get islemi tamamlandi. ***");
        putPetMethod();
        logger.info("*** Create edilen pet icin put islemi tamamlandi. ***");
        deletePetMethod();
        logger.info("*** Create edilen pet icin delete islemi tamamlandi. ***");
    }

    @Test
    public static void checkPetEndpointsNegative(){
        getPetMethodNegativeBadReq();
        getPetMethodNegativeNotAllowed();
        postPetMethodNegativeCase();
    }
}
