package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.LoginRepository;
import project.app.shared.authentication.Login;
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
import project.app.shared.contacts.CoreContacts;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.authentication.User;
import project.app.server.repository.UserRepository;
import project.app.shared.authentication.UserAccessDomain;
import project.app.server.repository.UserAccessDomainRepository;
import project.app.shared.authentication.UserAccessLevel;
import project.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(40);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("oMPzNzuc4tytxOoJPqR1YQtijQ6HIYZtuO6SNV1uOLgMuXLYXA");
            corecontacts.setFirstName("MtOKicwkeIXzkkvhf75WCZJmFfcdlOYDoT7nLUMZaFvJxwwDkz");
            Gender gender = new Gender();
            gender.setGender("rB9GPcFGpYNoXmh1VjaquhHRvdZuFjiYB9mydzRC5kQrPisT2k");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("yY");
            language.setAlpha3("G92");
            language.setAlpha4("9vjv");
            language.setAlpha4parentid(10);
            language.setLanguage("bUr8y1zT1tBSqYZcVkOLA5l4yrXZTGzKRkb3VRJqOlllnAncEc");
            language.setLanguageDescription("OEdiJtm7JUQsCLCyxM5WNtaH5ltlqWbO8Jan4GlnCZEIiTlejF");
            language.setLanguageIcon("mTk6Hn1xuCaY7UKDXj0hauLzWBCAwCZvwCEyUS5vHdtxVYtOiR");
            language.setLanguageType("063O4VQsdCcrKzbD6qK8ypy7CCy7lxzM");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("RG2ds2nFRulPZC08P9xzR7oWwI2aCoVBEJj8ZNTHqPnp3cngZV");
            timezone.setCountry("4MAm5dbT11hN6WuEUnbELiYBOOrDQfeHA3LCkNITqmkjdxIvCe");
            timezone.setGmtLabel("F3KvUKGkxBm80ZlWL8JSnkzPjGiJGA1vDiPtBfxLd9WkKpnsSV");
            timezone.setTimeZoneLabel("mQbL0NYWi8LjkbrE6bLHm3eDOGrkHPgTvtqOo6dY1v7bDenGJT");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("ZS4NjFYEQyTB759b2xsa3uKHZ22GvmPAxQ7A023D4llh9azZnU");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(1);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("G8nSMusfBmZAbpNJGxiSwQMPGezABjvyckjZXkXyrNo2Cb1nYS");
            corecontacts.setFirstName("4pvkoMSdGVXyKQf6IU1MmIKjFGZDcHUDqOzeWuGmrF7fxAlrFk");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("wZsV9em7aHKIMAYLOwJI0Wpw1EmhjZeETRFy0Cfwa6BYOixXty");
            corecontacts.setMiddleName("PgWea5EJ0hzhWKbAB1nnxwRN8tqbfGnAormyR4FVVqbMTxYlIt");
            corecontacts.setNativeFirstName("Va6JLgZpbK6fc0TetwgHitvMgImcCmgYUiDAZnIKu46rEk2NT7");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("mau6BkTr3ssgk5tZ5DyYnLYDbYtfgYiyU0sQPmf76TxLE7FhPE");
            corecontacts.setNativeMiddleName("rjaAHlx5kqBXoW0d2I9u3lJUARcZuNgJOOUEGOfukWrDHhomPl");
            corecontacts.setNativeTitle("DpJGBIwfQbGBlxS7B1tWtuNVMEomaFz5x5OnBjOFH82JNsO97q");
            corecontacts.setPhoneNumber("S0hVcPk8ncPj55dXviHn");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("Xn3g1rqv1ZfShTb0tKPqayBsPhXSJ8bAC04yKL3d7yWCQBCdoy");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2225);
            user.setUserAccessCode(2);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("CGiLEYZ0S04XTbehq51FMIA1OdH2zHUkKDdvkLaCFoLl0JJod5");
            useraccessdomain.setDomainHelp("DXEzWoazjfcF1QsaHL2QOjQPjLIEOgmFCRevh0L7V7sIUu82En");
            useraccessdomain.setDomainIcon("Z0ZlcltsrJCA1jsqWkNM9HiY8elj0vycxoFMeSK8BOE05QeIBB");
            useraccessdomain.setDomainName("lqnzuQQpGvbx0WLQ9hxl1Mey0BfbQNX1pwsKnFftEYr066sFEO");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("LbPLm9q8w4GMHbdVpqK7Kjup4r6myZaBVmivZPpfzeVrFDvA5a");
            useraccesslevel.setLevelHelp("n5D9WvTGpI7O5hrnw25ucnlsXkRybvt3N93Y1CUwaHzUwdKNAE");
            useraccesslevel.setLevelIcon("k8RVtQL8nWtPqGqP2mW9GkvV624oGoTlQMwEwUFVjFxbViMM4J");
            useraccesslevel.setLevelName("fvuBeSAIbuCx8G6UU6doZ9PPJsXJaYzjgFjSC8jMCe7xYfkZk8");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("FX5KmdraBcsZk7AKOOzVHrYKQl4AR6v1ftIM13q1YB2JqEVgui");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(1698);
            user.setUserAccessCode(11);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(0);
            login.setIsAuthenticated(true);
            login.setLoginId("6DLVQKR8ymDYBRAmJ4pc62Gd3ZYNBOxlHtX897MFKxrFcS4nzu");
            login.setServerAuthImage("OSZnDQntypn3DDdIQzf8AYoQnHaooJfV");
            login.setServerAuthText("m4RhHjVyfJR6j0Ya");
            user.setUserId(null);
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
            login.setFailedLoginAttempts(0);
            login.setLoginId("VkuPcf7dxG7hqYKHTNfXOkAJGuQ1lgELZHpNuTWEyFzcfAMURd");
            login.setServerAuthImage("eIUeZ7VqWUrY5NHh8fi5Oac2UvTYCzZy");
            login.setServerAuthText("wkTdO7M5sEffMPYA");
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
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
