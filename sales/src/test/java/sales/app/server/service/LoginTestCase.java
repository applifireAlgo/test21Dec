package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.LoginRepository;
import sales.app.shared.authentication.Login;
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
import sales.app.shared.contacts.CoreContacts;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.authentication.User;
import sales.app.server.repository.UserRepository;
import sales.app.shared.authentication.UserAccessDomain;
import sales.app.server.repository.UserAccessDomainRepository;
import sales.app.shared.authentication.UserAccessLevel;
import sales.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(20);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("QM6Mk4iJzrAwKcCLurdd4tLMrhGj7KhWy4opZ7yxo8aiPPgc8y");
            corecontacts.setFirstName("R9Srn3cOAvf2DYfVzDytzCpg51ZCnLtASm2uOgIFR4Zon2vd80");
            Gender gender = new Gender();
            gender.setGender("cTDDVu4tiDlottQ1J3H3NFS5NEpo2pTucHuuEZ48x1fTgKUMvF");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("LK");
            language.setAlpha3("hVH");
            language.setAlpha4("tjGH");
            language.setAlpha4parentid(7);
            language.setLanguage("teIwnDJQwvs62O31ldsxeOJvHvY6SnSWOtAWSv5E2QMU8ykVCR");
            language.setLanguageDescription("XukVgHml0jwlA3EiTaYQ3oVfM6XjXf5vXEyNUivhPcVr0Bxd24");
            language.setLanguageIcon("oG2ALriFARHOpPVxgaOfyxRHvH5uzvVIMYZYFcRwtkChXN7303");
            language.setLanguageType("bQBlz3vm6dmx4GNbwzcIbLHQzjuJ9Qaf");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("wsKtvoIqPB8fBHiY27seUUH47E1z0QYiNitOQOvnuOZp5Q2hVc");
            timezone.setCountry("vG657ZrOIfatFZRdS4qlDn0CpoVMo3pUs8XtCjhaIIZKaoaPHo");
            timezone.setGmtLabel("UoU95KLw4ohA08cEGONR3hX48eSLwrid1RBqYYfz0OHRAYQioB");
            timezone.setTimeZoneLabel("NCkyfhEDjgnnT7T6gyn57VgCfWHEus61G3exNja96ODZVenK14");
            timezone.setUtcdifference(2);
            Title title = new Title();
            title.setTitles("45ygFXaNeVwSTDZRXQfDaeiBho3Og49a3wMgUMm3FvqENpmdnZ");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(124);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("7GemJslT8hMLgOKwz8smnP7WiLCd3UbiVVZmWiITXdubo2xKRM");
            corecontacts.setFirstName("RhJkjW6Bu8QqoDkhZSUvxpSHtQdepWxcftRue7cFl3z7JTZ8bC");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("3gf4C6dOIpeFicdj2GE1JQJter5Z2NhRRMHCrxW9oeynOjbyB5");
            corecontacts.setMiddleName("XmdhIqQWqXhxx1WRNtS1NdfxoSFBh5OOUPbChZZjzPhEQznGpE");
            corecontacts.setNativeFirstName("ECRKLDAfHG1GqkSzW8Uxc2KsaAQpPyATn5tbIik00RUV5Y7j0H");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("SPrUz9CjgMAn2eZL410B2L3LF3En0aUePn4M0PWMVMx7P7rq4Q");
            corecontacts.setNativeMiddleName("srLZ67zxKi297JXBeyi4WVw8GgHJaPY1ewQ7l5mAAkT9PjTyxT");
            corecontacts.setNativeTitle("z8BHQ9Xo4B03Rdbujmzu6YQTxvPugitgp1CR3W2Vq5WOq1bQg6");
            corecontacts.setPhoneNumber("zavEy9pnWiWsVO6fGdGa");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("KGgEBB1sadKeSvUHxYcSE8hesn8LoRVxsnRpmu9p9HV1tLvGAR");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3292);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("NHzClgh5wEpw3SJ8mhYChBeMK5wwwupeBmKVA6GyI0gIglSj8V");
            useraccessdomain.setDomainHelp("wtaO1mnB6tGLa1kuUWJVhNk9y3ATHVnAZzXMHbFg3s3cX7Jd1b");
            useraccessdomain.setDomainIcon("15Epu0983ZU003z1yg6voqlzL90b84oRR9JZolXJvLHuH8rujz");
            useraccessdomain.setDomainName("tDgLVof5sa475UnETsCd90nPkA2R1WBNXSntxR0He7A8gx9UuH");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("xlG5VoUoBfDWN21RJWFG533ajKYKvnaDjMR4I2fGUtaPPc7jHq");
            useraccesslevel.setLevelHelp("BVlYF4twrRmqDAnVCx7MDfw7anFQwdHZ8w28dhxVRofw0bKTzy");
            useraccesslevel.setLevelIcon("JzbStJj8E1XejGk3BGHoBiUteDmEWByWBJeCtGqOCiSzpLFZxP");
            useraccesslevel.setLevelName("gBT7qOz2K2PYvydB8WocBHVc4zgMsNjhf9F0gRX2ufg39KwB4G");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("ny3bhOsaFGZcmtdVrdkp5QicthrIvGbXo3tkVWr8GiBidbwhvL");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3437);
            user.setUserAccessCode(6);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(6);
            login.setIsAuthenticated(true);
            login.setLoginId("jxfi479fyj693ZCjVzU7XFgHYYnXEI4RVquLjmX80JsFQBbccn");
            login.setServerAuthImage("bRkFfV9gK4cZBX4myadFH3bM8O6L6y5e");
            login.setServerAuthText("GqFzUvBmoTpDllqp");
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
            login.setFailedLoginAttempts(11);
            login.setLoginId("QysNRJA3ACbvAG8fQhN4uPtahoMxQ7zmxMG4XDMcC49enRxEY2");
            login.setServerAuthImage("nDdnqem8kQJE2diAlzNi7qN46HYhK6qW");
            login.setServerAuthText("UK5JWKxjkrbnm7Hz");
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
