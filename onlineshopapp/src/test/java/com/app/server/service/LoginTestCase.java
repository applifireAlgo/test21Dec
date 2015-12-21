package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("s0JoNO66amAiCIETZt0WHgPkG2NIgqAt2Givb13L389VDlHD8n");
            corecontacts.setFirstName("yuxfHXFTKCmfJx0UiRu53iMfIVhKwVi1mTTsOvSAf4p20kiUKE");
            Gender gender = new Gender();
            gender.setGender("HGAsW995z5HDZamtO84Z6trqPSXslaiRMcfTsSWfIOmzN11uRX");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Al");
            language.setAlpha3("eTX");
            language.setAlpha4("gVOg");
            language.setAlpha4parentid(5);
            language.setLanguage("U6RrVlPzeD5wvc0qOXCxGIFLyjAwro0HXLOKw6gikQ6TQkndNh");
            language.setLanguageDescription("pCYDdyLl3Mo7h9hiZkZQBpipoGWiyBpQOnFfoNBzQMPzlUnjjM");
            language.setLanguageIcon("qV4LRQFYFMME2S5bsGKv6ggykFoAJcooHFrEqYdl7lwWmjQ7CI");
            language.setLanguageType("PCDEoksnYsKaEDgBzROnGK2YnhrPHic6");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("rL9RPP33LYf6pUB1TiqmafOJGV5TrcT5sSC2NRMFXAVOXO6wE1");
            timezone.setCountry("isf52mMXoexkiiNwXAmkP9BVGPCdjajO2en93sf3x0UkrSRGwR");
            timezone.setGmtLabel("J1vO7A2RMwXR8NZTNJRAO42iIxTbNf7bauVkNZ0uE7Stqdbdqp");
            timezone.setTimeZoneLabel("tChxifnPHew90GObMXL5cPQBDbWwsmTXrBHlEIM5wGvmRKlK13");
            timezone.setUtcdifference(7);
            Title title = new Title();
            title.setTitles("nBmDWqjS5sXjilow7jzmgzWTaveH7J8obuaY8Aj4yELMfvtN9T");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(41);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("UUVLoekQIRWvGqeF6M9FpkzKEoa4FuAiakbXppLk2GQd0zER0Z");
            corecontacts.setFirstName("UGe9Bp0oHUGKayIHAqKpScZYvXk6y3J9mMurm9XP7g57QkW9AK");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("xZvZ9eHeaG4YAQaeTytPoEkvePgh58MlWxfGkGSQ27sxEiXi9H");
            corecontacts.setMiddleName("zqIP0VuOwS10EDcLT8RcfKGdsWRIKtEfKDk9IB69bqfIYLplyy");
            corecontacts.setNativeFirstName("m2i72BAnvg3imCGSRZsTGPVq4i9LSr28FFKJUV9HE6Zc48FOQS");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("oXuK857fdlivi81wpY4mBKyfwPpUbJN36wMUfmdRTodt7xEfUr");
            corecontacts.setNativeMiddleName("gVHZgr4Y82gVR5cdyevzhlgLSaHBWgHtCjnQ6v9cbnFK8Vu6XW");
            corecontacts.setNativeTitle("3Xp1aaoMbRyEXmtRunaVHJy3DvuOEmUr1lPcBb0bIcwuTwuOnR");
            corecontacts.setPhoneNumber("fkoZZ1Z6CdQl8wvgoorm");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("3oQF2geRf5VLaf2VhloomYBtyn2IgoqWUs9z30t5sjSjyv1TNb");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1462);
            user.setUserAccessCode(1);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("21vY6MCjCBOEPomezeKQGxTkklBjA3qZIJbHlMqG6kEAVDkacr");
            useraccessdomain.setDomainHelp("9QfDMKIcriWmrvnEyduoabDe4qGeHTcSQtfyExCzdnIyo9t9AB");
            useraccessdomain.setDomainIcon("3I2qNqxyFFu9upRQfh48IW1t5TodWaTrbQdc8QtESKDsCdO7k7");
            useraccessdomain.setDomainName("S1qOCnV8o0K4aJzxuBsx4XsYnldTEuR70M0Y38atUAcS9hcwMB");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("GoNnop8UYlwG1iZf5JQyBk4wfANax7Ser1UjsVvnen26B0i5Ii");
            useraccesslevel.setLevelHelp("o61ChIM0hE89PPOdWd6AX2EPnHvl4Mh0jFJMMwzCU3XMNngD3H");
            useraccesslevel.setLevelIcon("KJTLunCbOdUXS7pzBvzFsvLwS7tYOFXnOPP6VQQ3mPT2fDRNyO");
            useraccesslevel.setLevelName("VNM0upFxagPeAZkPvfwHSDCwPMbDVp1Ipf1JLuMWsu5u2iQ1pi");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Ayzw6Hpkw30tVJpu4FKQyQ6VTivE3F6h5mEAWv7vmD3mxWKtiN");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1861);
            user.setUserAccessCode(1);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(10);
            login.setIsAuthenticated(true);
            login.setLoginId("coedHUFsCGId19UhQuw7MxpqwqOvTS6cxQlxhlenfmq8ne7SlR");
            login.setServerAuthImage("OrxyqtB106jAFZTclD7pee1nS510jheU");
            login.setServerAuthText("V74ktHzfWEXnhD32");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(8);
            login.setLoginId("mHsTBDHVaybRCJAtlm41Cm1RvoCHk9aaBETM3xxFtqkjdaM63q");
            login.setServerAuthImage("yDzHHfHa5DTRtDfwTqISbswaWbQxOkju");
            login.setServerAuthText("7G7SOJdL11S4yQ9t");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
