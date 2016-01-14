package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.CoreContactsRepository;
import sales.app.shared.contacts.CoreContacts;
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
import sales.app.shared.contacts.Gender;
import sales.app.server.repository.GenderRepository;
import sales.app.shared.location.Language;
import sales.app.server.repository.LanguageRepository;
import sales.app.shared.location.Timezone;
import sales.app.server.repository.TimezoneRepository;
import sales.app.shared.contacts.Title;
import sales.app.server.repository.TitleRepository;
import sales.app.shared.location.Address;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;
import sales.app.shared.contacts.CommunicationData;
import sales.app.shared.contacts.CommunicationGroup;
import sales.app.server.repository.CommunicationGroupRepository;
import sales.app.shared.contacts.CommunicationType;
import sales.app.server.repository.CommunicationTypeRepository;

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
            gender.setGender("LzkHGzOmVxLPX9YxNmFAUYOAMzKefXbDoE0pwL2wINQulQXXmz");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("BX");
            language.setAlpha3("s0d");
            language.setAlpha4("X2VZ");
            language.setAlpha4parentid(0);
            language.setLanguage("nchaPt9W0Y9HpFB5V9yNV4D0O0OREPHorTRxpYw9oFBy2SxR4f");
            language.setLanguageDescription("IC79EmWT0kHZ8ylbNDpBRFUeIfghFUdGYgcwCSel5AQVnQiWpT");
            language.setLanguageIcon("hDQAg99gipXvNWrRldAX11Xee76jwmJPXRt7eN6sWpi7PjbtMB");
            language.setLanguageType("F4IR2WOkHBu9zXAuLLRQchVFnN00YqkS");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("JCySE318vPdqilykq2EFqbI2GM2GyxbvA1PLB6iXaH2HKqfpzc");
            timezone.setCountry("gNdcX7nbM3s1Jh2NuzhS9o3v1zWae9HafL4AiLpufUHdbvAEnH");
            timezone.setGmtLabel("kOwmP3MMLa293UNfdIG08AAgoqxTZqWPK7D07vW1GM6wVjxkeh");
            timezone.setTimeZoneLabel("v65vj4FR2Omf1pfBAQMCuLB3wEoBvVPSfNvCjNRr90KyUy3dRl");
            timezone.setUtcdifference(10);
            Title title = new Title();
            title.setTitles("2Ykkl5fqXLhh2w5rr9O7sTuC0VvQSu2UKTcc6cJzZHstnHKQMx");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(53);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("jlLs3Oc2zCsjwY7FWkEeDlVomLA83FB2IU0ksh7VAsNSlHXXyK");
            corecontacts.setFirstName("u8LTMOmlo3HvHHRoTjqVJ2Ctq7wrID27WAGhuWdLm8nKdR7PxR");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("85DS5gZHMob8lrWlYKwsPAYzfxdiEcARde8gn4T1NpH0Ucrs6q");
            corecontacts.setMiddleName("biujIKKeEpbVazQ548Ds2M1L5hTG82Qa7f21Fkvbjex9nQFURb");
            corecontacts.setNativeFirstName("QZRzQhuXDyACu1AidsZ0PZEly5lluchzbgfdjve1VrI9sHiQ41");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("DBEVlcYb9Z869PSkt2tI33UkdUCX7qBYFVwtMuEJXcxZn6uSmV");
            corecontacts.setNativeMiddleName("THHrpt42nlJcaaQGjDcssZJYq8MtV9s5qLBFiVQxs3UIdoKxGJ");
            corecontacts.setNativeTitle("TPKj8iIjWzf2h7LFev7x1Igw4SkPLxiZTo8aXFcE5Ei6zpFNQn");
            corecontacts.setPhoneNumber("kGHlyA1FBT2Y5itvu3QE");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("QUtd7Puqu2pHqva6oHdpelJvJerUKWXWQuWuNGpofGEz4rXnJP");
            address.setAddress2("wpuXeAAfYQHHRba6qKrOlSkmk9y3lsiX8kpq1XlIHy6aZlfV1l");
            address.setAddress3("BnqIOp5OgWTPVyN5Bm5MDdplWjUKwUHBEEt3TFso9sdiSsDXN0");
            address.setAddressLabel("tsxrwEAkHe9");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("kQhNPGi7IreimQ3BDEsvdvy0rUJcbgNs2DLpN5BHDpCfxYivIb");
            addresstype.setAddressTypeDesc("mY57U4IXzgQK1yM7qAJCkIUX5x3iTYIWJMDKhpc19QUJE6jMRB");
            addresstype.setAddressTypeIcon("N1YufESx1KSkno9wTcvsRyuQ0BPmhc8LTbUyW20X7Q2AXvEdeN");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("idVYkpK2mFjFmuW0aqbYt3l4gc74KEFr");
            city.setCityDescription("hAjEnGSGmrfsUPQY4wi5gAG2yQxIJtZcTGJUsw9rpySrohjz7D");
            city.setCityFlag("AiClEDC77TNbpGuxw0OyiUb7txDw2EB7Ru3LuHc9vjvf6veTiJ");
            city.setCityLatitude(9);
            city.setCityLongitude(6);
            city.setCityName("HsHJjwMhFJ1dhTC1r9KybIO7G7LIQaUUqNUgFXwWIlHFtVW2rP");
            Country country = new Country();
            country.setCapital("GPcVbqUCAWd2Hrv5m8eTRQedCa6Sz96V");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(4);
            country.setCountryCode1("fHz");
            country.setCountryCode2("9uf");
            country.setCountryFlag("INDcyb2vTSpenzcBY8dcgalL3PjwLpvsZvXV4NMHGEuE0lFzUS");
            country.setCountryName("XTSebaPrYKdhOHRDYDxaxs5W9mK6E8GWGJNA7ZCs8vCAJxJfj3");
            country.setCurrencyCode("gQs");
            country.setCurrencyName("a8I4saNDEmz5GoceqrdkU5JziWKnn7T7fuNuWLKonQLFe0yTTi");
            country.setCurrencySymbol("M7s8skF2nQns5DPLGMMPH774TMCMjy2g");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("2zAe57iKMiAidK4TySoqgapRc2v7xTU1FMBxbnDm92lzx67AKt");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(9);
            state.setStateCode(1);
            state.setStateCodeChar2("O4RBKxjIjsnd5LH7LP4we1R3EqZKjoMM");
            state.setStateCodeChar3("mnn2ERF1lEwDDiwBuDcIZnSho43JUXJd");
            state.setStateDescription("cEqDXgN2HedJbkkRN1JtDtvca8LtXnWNYicA1CgRUxl9z5wpMz");
            state.setStateFlag("N8hP7dyhx8fMCiAsw500GerV45JhaPpmCmJHx1r0Kx9YmkV4c5");
            state.setStateName("f9GQNvtcgarWS7SN33DnGJ4MJDChhRXIWVbeG5sBQWCpizq7Bt");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("IwKvfl6KQV1Hm3KEC9uTixcEXbRB1WYE");
            city.setCityDescription("tnLuI0tld6Jv8IdZ6pkwco7B4AWT6qq3PuiLPDmdvO2dytr2f0");
            city.setCityFlag("NyKolVLZptIBe8Spz4aQUqEeOP3VdOndSkPaBbZggGxRZ6LWty");
            city.setCityLatitude(6);
            city.setCityLongitude(4);
            city.setCityName("zy0jQKWDHnYTtfsSAP85zqBJHVpOv5hw1RyKozrh9BMxr3F6LQ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("nkE1F4PrGt4QhTFQkmpMRPTD8xEmYHYAiyTe9hklcspoZAA61w");
            address.setAddress2("6yPMy3jRp8gq65h34Hz7TIf93ThyoG45ZVPqJcYY0lm1SjU5M3");
            address.setAddress3("r9WsoAr3dZh6L9INS4l4Ho0yxaChmuK5iIMvwLBPdqnkwCaK7k");
            address.setAddressLabel("39bd1KWogrM");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("490q5GpJ9nwP6kTUbHUM381jdYghmizlgraj5Jz4iGJPZ4Jmb3");
            address.setLongitude("DSBRQ3FjzO0Nq7zImkU7SCEbjFi5IvF6SkGen1KTBftvvVl78o");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("vT0dkB");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("7wM");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("1P1eFc2vy9DCwuknhUjIECviC8LlLEWKTTii5AWKcssufsGHn8");
            communicationgroup.setCommGroupName("cLliEVbQl1CIwxbUO542VeTeYxpqcHnsIhU9bxsU7zE6Eigir5");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("6SHU93OI8XN263EXFgEtebMam3NmqcLagl9gROr2BJhWDS85nt");
            communicationtype.setCommTypeName("ChYMmFD9ndY1UaeEv0kMVJoQy0IoRA6TrOcViDTSEo53ZvUXxC");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("LYG");
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
            corecontacts.setAge(39);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("9MD6m64WvEfEIMp3PyAfNVRdu9p6mUR9xEWTs8OVk1RcxUpMrE");
            corecontacts.setFirstName("XgJRezoi1pqVhCfeewQ5O90J2I5eHzowKDrAF2R6D0a5SLpySe");
            corecontacts.setLastName("w9oSEMMeJcdws2B5ZG3163ggpbB28V1YPUf2CSBvvFZbJjhjvf");
            corecontacts.setMiddleName("Yy4OH0ZVGa9cXtrDhg2QDgzSqqU7Z7MM4XSMcDfrd6h2HY5zYn");
            corecontacts.setNativeFirstName("KtCgHWtxN0eKKi3eD7mlWuqIbyE62KhFxGpGXIPLhyETh3eRu2");
            corecontacts.setNativeLastName("AfdJbeDWrYPEiUEEtcHNSBzZG1vPtqVkOUOcDSKq9fbhbv3ozq");
            corecontacts.setNativeMiddleName("2dR9DJlgfvGb9Nbr7bqBfoOA8YPLiff3GaxWiIJbNOQphfukYa");
            corecontacts.setNativeTitle("ApvxWRFIe4A60kLa8u4WTAuAdqFdx3DicdPGiz2xSh9hfoXf2w");
            corecontacts.setPhoneNumber("vRWuNXP5nalrOC2XGOZo");
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
