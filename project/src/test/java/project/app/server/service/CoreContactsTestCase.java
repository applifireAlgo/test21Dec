package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.CoreContactsRepository;
import project.app.shared.contacts.CoreContacts;
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
import project.app.shared.contacts.Gender;
import project.app.server.repository.GenderRepository;
import project.app.shared.location.Language;
import project.app.server.repository.LanguageRepository;
import project.app.shared.location.Timezone;
import project.app.server.repository.TimezoneRepository;
import project.app.shared.contacts.Title;
import project.app.server.repository.TitleRepository;
import project.app.shared.location.Address;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;
import project.app.shared.contacts.CommunicationData;
import project.app.shared.contacts.CommunicationGroup;
import project.app.server.repository.CommunicationGroupRepository;
import project.app.shared.contacts.CommunicationType;
import project.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("9UBUNmvJAEyb7oWq68AwhNG425DpygK0hM4alJvwp2E7ga5JXf");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("5h");
            language.setAlpha3("Wmk");
            language.setAlpha4("9BuF");
            language.setAlpha4parentid(2);
            language.setLanguage("x48ibMKcedHtm9msgtG6ubJ82bybWzTBm90WCyAu8Ib0BxfrA2");
            language.setLanguageDescription("gG3pHo8Pe25yhwIzShZJaj76Lzmq0BvPsM0IRbJdUxlD1OyNb6");
            language.setLanguageIcon("8x5dLgiLN042MdCYPAdC72x0A2FhERFVj7phEkapQLqMwFpCEI");
            language.setLanguageType("HrGJxgs2mBviRgfLzI27qzh7IPTOZN8j");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("KsqIAOow6VcD1WDAIE7rtxhuaXxOVjyvKGab060spSTms9Sf7Q");
            timezone.setCountry("V5DgXQZBi2y7GTFMWOnkfSadkeIj82Vic24SlfOLMBDoqnTY26");
            timezone.setGmtLabel("puXSyP1ITDCSe9LAT3EQpQN3hGhDrxoVEItUxrEoTzI3raoRAP");
            timezone.setTimeZoneLabel("S8aVXfwxoxx7t57yDhaOBXo031n8GfvYF3eeCVx6rM2OpLG3Uf");
            timezone.setUtcdifference(7);
            Title title = new Title();
            title.setTitles("SGcE72c6hWvBWDahmPeB57dIHBMLVF2XyiLH1Yi6sLJ4vdvxHP");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(114);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("ihWvrcVJLdnlxdHt2Vx5no8TCPeaXlQPtEWuEvbYnrXAu7vCZD");
            corecontacts.setFirstName("sWAtjTRmsgKcjvRx8rYgcn1MBWuGgsW6pkAT4XL2L9H6Tcit2N");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("OWmZeJ8LU8cSGbn4yN8Rx8ZleeivAI8nPfeyJfemnqMsvCptzh");
            corecontacts.setMiddleName("Yx37PYRCOHcQ3Vi3bNZRkw5N2Se1S4849T5o49nMY4c10Lw4dY");
            corecontacts.setNativeFirstName("pzk7NgBAhEpolHFNZsiH9GIEy8ZWsbBNUprlzaIKN8YtvUlsDi");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("3pOT6LB99EuAxmC2OOoljQsMLWa7KsjVFRXh2F5pWUDRsk2gDk");
            corecontacts.setNativeMiddleName("Id32iCq623IPxBCZcC1TDISm9Abk7svKeMbb97EFcRfEmmaMvu");
            corecontacts.setNativeTitle("mw2EC4FrAoF4LyZVBQBvyAQju0XCqcCUhKW7rvwY0NJ66Co7AR");
            corecontacts.setPhoneNumber("JwuEsapFUF9LSKqrV5cI");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("0CXRqi1cSBj9F24OPEYcmD66HS7GwCyj3VFRgxt2UhaRm4GtMJ");
            address.setAddress2("gmZ2JgXJrVqJDnXETLkNhHEHnQZ39rBd3SyOwA0aRSoWRvQ9dR");
            address.setAddress3("bp4Web0oRieJb7zi7vyxJeEhGLaEsO2HvFKnUidsSqCEzz1SxZ");
            address.setAddressLabel("aogHJy4HzLs");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("OKa37Fk569n7nhVwjlzD4KtidggX85Liht6TyivgVSqIDRVl8s");
            addresstype.setAddressTypeDesc("y9aNMMilxCKWKUV0C4XbK7dWu6JCsZpBFl7xFscyKsnMTRz6jx");
            addresstype.setAddressTypeIcon("EWAGczqyeD09uXUjClYO3RCEjoozvltwccqHkeBaTRPfw08M1G");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("rVREfNkpWJj9UXhpMQ2Agk4Uo8uwqJA9");
            city.setCityDescription("C45BeVumbbN7Vxtk2ZaPuwsL7hAisaRTB5XdQl5qYJixa153jy");
            city.setCityFlag("YaDMonNr0uB4i332bGkYI6KFwSYN9tNyo3guFnXr0dH4lM6cUx");
            city.setCityLatitude(7);
            city.setCityLongitude(4);
            city.setCityName("BGZtjoJC2ZflsBCyNeFTmU6PvCbsqkWXyTW4rBkrG6B8G7Picw");
            Country country = new Country();
            country.setCapital("0p4rhNSMisoYM5TecBKynn5rhOArzkDR");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(2);
            country.setCountryCode1("JoA");
            country.setCountryCode2("RHQ");
            country.setCountryFlag("6pKbY9S8hgf0Na7sAA00kAqhrQZf6SkayXNWW5AcE9naMTzi0q");
            country.setCountryName("fpCnwihadkAfJU3mRkEnKVwGN3CTQbaqWnfxNPamBcC3qEoJpg");
            country.setCurrencyCode("s76");
            country.setCurrencyName("n4rRscNQM1FWeUpjacyAaIHDqCy4AzY8vBXIM6cpQI7rvKECM3");
            country.setCurrencySymbol("HsOwJo9Bz90qcxHjXV65H3boRET0RPfs");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("qLeQIeLDPVBCg56Srm2yh9lYviL4n4Hx3mZmkT34iWgOAUYiki");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(1);
            state.setStateCode(1);
            state.setStateCodeChar2("eYMrDrnyzpj7EngscdbkBPrrH8vatBdI");
            state.setStateCodeChar3("NJIlECqx7cT2uIRP3uoX52RNUR1h2mGJ");
            state.setStateDescription("Ul6l8bAve7BGHwMdxNp0ilunhMhAHzVG35v9HQC9Pz0HqTXydz");
            state.setStateFlag("e6vxdsOr0fDJNULWYY1SKasgyA7xqdp6ctmafSpPD6t2DkQJJK");
            state.setStateName("VX6RhPSIGnrD9Tix3EqELp1JFInoAFlR4OqvJVAZccuUE7zKnK");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("QK13dOfjCvjw1WIOkajCBbVdYoVfazkE");
            city.setCityDescription("8g6JpmBv0sby8B50yjPkWk8BnrB6VeebGQW9Q7G0wiUBB529Us");
            city.setCityFlag("6byQGODQCWMRmtMRVxnJu21OPVI8CdzvXTtTequ493RC7REgZa");
            city.setCityLatitude(2);
            city.setCityLongitude(4);
            city.setCityName("qXiNd8QejGxBSHt3TJbFPkie4Lic1KqH2DkP7VTtEHW68AVzLF");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("ui76EQJ2wklwRwRjHJslfxhZRX0aP9TY05TShdHKFNx4g012eg");
            address.setAddress2("ML0PddGAH13EGVq0f0YFmgCfAEUHnGYamOTJWiTmi498tTqLjj");
            address.setAddress3("TprTdLS7lyEfLlE3gGr6xVT9ePGABCFZXWhXmDTJD5btoiwpJG");
            address.setAddressLabel("aX6qm2ph4LC");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("SnNltgdKBjNYqDu3qTBgfDHMEEX2Aa6IpqBWaljBZyBnFU7asJ");
            address.setLongitude("KqZnTFCrIfDjbQHq9FD4WSsN0xSWw5YgOj7LGrwiSFevg5PFsu");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("dagQKr");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("WQ2");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("oDtDcvmIbQo7Ux7pWejKkTsWyqxDWIou9yEKzBl3HPsabpN6QR");
            communicationgroup.setCommGroupName("Bujbntogp5do1mLZixSLvIhfCoLxcMG8ss6HkMBrj84gQmPHDG");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("HNF2BpBXHTzOvXCfKl2gdhdtaMLKfwMpSMWxeTWa57xYRMaEhp");
            communicationtype.setCommTypeName("MuyFO1Wp0ySpkTbCR526DAcGuCjgVFSLIF6hHszVBKCRztnNxS");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("QjQ");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("HXv2JYMbZz3NKvGufsQ1AASJIGtlh8di5CzfjfzPxyLRSLVchB");
            corecontacts.setFirstName("j5PEhj5R7oQul8GK1r4j4oTwBRG9MtyfvcPlqZpGMRjjctcU5X");
            corecontacts.setLastName("IgVT7x5oC8r3Qd5n47A9Tpg7BGaNjx2EwRZuMW9NH0GHPF5fl3");
            corecontacts.setMiddleName("pLuJZSQhNSrGxUhAFhIBBFOXHpdqwx6jjUaPGyLC8g8ecvWvy3");
            corecontacts.setNativeFirstName("IWFxOXzsK9dVkvnGpfIffJVrnmtAcmDSf4vLCoLEuxE6JFUbSa");
            corecontacts.setNativeLastName("p65rh6KEN13FZahi7BO5nZwBzHCjuDwn6PByYPIPhgtvG23wnO");
            corecontacts.setNativeMiddleName("yA7vS7HE36tKN9OrYCUpd0NdRsgc7byTnTOEh4HgdqfxRjRGm9");
            corecontacts.setNativeTitle("f8g7Ccaw0Q1SuRaQUTN696FN3ZKg9nwBh2jn19TjrJPKMVI3Jr");
            corecontacts.setPhoneNumber("zLigKRQyl2p3TPneLCME");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
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
