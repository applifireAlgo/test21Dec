package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

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
            gender.setGender("F5HKkrGRzTaVpKPbPLSyNccFpszbbY8wu5aGVFrYlUH47gl3Wh");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Uy");
            language.setAlpha3("nJg");
            language.setAlpha4("z9hA");
            language.setAlpha4parentid(9);
            language.setLanguage("3TJXp3qH4ikX1CntHH2OoYfk3kiPGS51U1iP6KJZnZfQsOH0UB");
            language.setLanguageDescription("q4ZfIFzBBYleh0bnxuhl0IcOMdATFujb52lBq76VCdjTUtdABu");
            language.setLanguageIcon("ZmpWWELKBxR41JtXWULGcgXgNzuZixNSKAhazaZTovERzEtrwH");
            language.setLanguageType("BWJl0dpx6W4qUY2Z8KeakfS2QgZ3VZwG");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("AE4LYLLE382I9M5onHK7kjBenwcS06JEikuSZ8rLMIkMYc5lYE");
            timezone.setCountry("w3V9HbhJdPG9fpt0blgbyVxcAgTAv8wkDyBi6aA07yUbSlhytm");
            timezone.setGmtLabel("J7o7ll1owLTbTw6DDMmePCPDDmweAp355OoPFrcbIbtyONMatn");
            timezone.setTimeZoneLabel("Japj2JJOLhdOk5aaskVTUODlWqhRi8vASgp2g9wwqLqA9YgxHj");
            timezone.setUtcdifference(1);
            Title title = new Title();
            title.setTitles("JswfZjqxyTfIoUnpVAblYKQfKG8kKxBcIiA5j7uEdIFfq2dt7k");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(49);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("T8zP2kd78suaZOuf7K850WgtgK7HbCji5G629SxKDllpbnDfeb");
            corecontacts.setFirstName("zdPaJXLCoze5Ua7gMpzZG3TIwWyPcjzpDjPJI7gx2B8VNpqXwt");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("2mdrgKAno8etfkmYUY67ODXa7U5A75fUAEWQGlILbT2uEpmQaf");
            corecontacts.setMiddleName("vAg7bmd8ejJ9dEbiKoYcRUxN3WJLR5YugrSBIkFygxGj3ccFKd");
            corecontacts.setNativeFirstName("iJBRLOzBpUiebSS9SZJjJjXixPFOFBuR5UiGC6A9PmyWCuvem0");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("q8PLLQh2Y3A0vX3F49tX3KyJa2dAsXUb6c077WkvHrrwvHdjVU");
            corecontacts.setNativeMiddleName("g2m2Zcaty6QxkEBdXXGJJQT0SIvo3ZfnC3UbEaCCBYeRlqveXZ");
            corecontacts.setNativeTitle("orSLnFXJIFtxsBqZADbGH60fN2EmgOvPaU9I20q6ks9bwXnXd4");
            corecontacts.setPhoneNumber("kcxpWsuGVR8qLfZnBSCN");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("QQO");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("6uPWZyhg3e9ocCeM26h2tztIFDU9PP6msel1PSdTGxBJ8syKDo");
            communicationgroup.setCommGroupName("ZDnaJEsxQ2H7iYlFT9sgzLznBOTvXFB1ExiQUl7iP28ujV1Vjh");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("hun3vHVklFDL5GaoulpSrpkMDTcsrUvTKEu4beieVLZ3dt26Th");
            communicationtype.setCommTypeName("2F2pqkBgf0sYSfWn7SpujKQpmKj53dbzBnyvjsor6BYC3aYTEL");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("wHy");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("wczKCPWFHpidqToh2gxwepvelffcTMLdDJ4XPUYTznoXqmhXdg");
            address.setAddress2("3IX08S0m6CEXJtOp6USO3Kb84vp6kkWK3DwMPyaFlLAIB0xRot");
            address.setAddress3("jTXbuQxBqXXFDj8tC5errxaGsBv2rqPnkWy1PCSLtK3v4juCbT");
            address.setAddressLabel("JP8P86dHFJr");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("xBMW2YMXxwV6AUQlQgzpw64kcXGkJG9sIgVXO3fxkpjcL9arhY");
            addresstype.setAddressTypeDesc("PTJ4NcS699LfHX8Nes3skdOeGi5dLIayFdqUAF0hx3KtnR8hav");
            addresstype.setAddressTypeIcon("QRQfybJ2yHDam9BAN7w0lLWesXAfAYThzX1OAyXUenR2iH7In9");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("cykvJzNHwHZwEYQTA1pcw1rTmb2qP1gR");
            city.setCityDescription("aj2KEIzElYMftQZQTaTzavjRorW01fwisOZSdR6XHfspwwurlQ");
            city.setCityFlag("hMs6YIZvn6i9Dfh2uunDqn6FM94q7Ht4IgsxkwHgnEwDc7Ul7Q");
            city.setCityLatitude(7);
            city.setCityLongitude(3);
            city.setCityName("3kZnuyv9hM3uLbBFj8VsKsMtZhEnWsf8HyZCRnaBkxntPc99hA");
            Country country = new Country();
            country.setCapital("CBptgKLFklCSdpaEDK1Tsase309Vosmi");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(8);
            country.setCountryCode1("fa9");
            country.setCountryCode2("Rsz");
            country.setCountryFlag("vVA7x1JSk3MLPqUbp95brQ8apwtcEZlPZsCUASX9dkMNfOFmnu");
            country.setCountryName("Lbh1njaWdt99Par8bg3ID92cKjR2yoDh3i11ODMS6ZYb9J0PIf");
            country.setCurrencyCode("aUe");
            country.setCurrencyName("CmQF79ps5XMcVhqUSuMnXqwu1UedOhhncmftVJhNEvrmvBaHPv");
            country.setCurrencySymbol("sNg7hUIkIsfU0GWkkcsStRAEzD9BZ11c");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("PwJCwTaiF3Oo3ipr7Ch5xCtRAygsgZQbzQFYliRTPE7mtjq3WZ");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("0CJyX1suVID7Ch7WQIcVJNV7vhB220Lf");
            state.setStateCodeChar3("iNq1kSMu4ZAKzEVkvK3XvH8OS7hQfZzm");
            state.setStateDescription("e5Pm7igNJwk371FTbVRDzZg2ZKvmH4Xas2kSTFKEzxxd9niLHM");
            state.setStateFlag("xqJWtNrSRhxvNEVZe9O8EfEWkWxcaFW9N3HMssiwMsXVln9iCg");
            state.setStateName("SZDdGIsWrSZjcJO6RTnNka2Bf3l712tNediCbGzizJElEI5TZY");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("PWySskYMecPJULjA69b1gZd58F6HZ50R");
            city.setCityDescription("zMetSkKqfynzvJg898cQ63u4BUdIgj9dxiLeW2DZt6ft0ZA4gm");
            city.setCityFlag("DmBqd9GvgwsRK7UHNe22XS8FdoX8VkoiimMkMs5a4qin6oOvKv");
            city.setCityLatitude(7);
            city.setCityLongitude(0);
            city.setCityName("pvcGKiMjNK2DBWSGRxQBItXxkBST0XaBgnbSkwV6pJYEWdqcXt");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("xplVx0Fc1YwWjpl0po6DNCHllB5K8N9BiApqwjmzncoEqV2IMY");
            address.setAddress2("cholopSGyh8G12EHOtYQTceTfkzq1wgBOrIiP5jOTHagWTSZmf");
            address.setAddress3("BUXPTa7kCqkwaQt35dvZkW6eyUai2x2qDFUGSW6auYODPiEdVQ");
            address.setAddressLabel("lAMlHAAAVDV");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("vvmLXDkf4limpfl7f4bsm1hKLQC2V3gXMYmEo2jNH6mEQQbgkX");
            address.setLongitude("r5Ku4uga2GUDUr8KlBs1gKx6kBu3NHxmZyJiaPCYe9g51N2FiD");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("M2Cnvl");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
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
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(36);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("YyQ3mfsJWFAW9eqrlOt6t8LyPnjI6ZW0i0RgZ971fr5qiUrOas");
            corecontacts.setFirstName("bpaYfKRSZtyV8aASABhuIEUqUaLVlYupdPa3Mi0aXmj2ACAPFQ");
            corecontacts.setLastName("G1vZ8wlRa5uecC5QbiHQY1sDYBBkXJdgkzz7s3Hy7HiOxsFzdT");
            corecontacts.setMiddleName("0BGWgg4VyD5l3PBhB0HgVIuyWYkjLsadGLehiKBuagRybln6FA");
            corecontacts.setNativeFirstName("OFt4fxqzQJeIIXWRV0WDxR5Gdo1TQTCUUKtUSZtGsjlFGeqoV5");
            corecontacts.setNativeLastName("wXIcLcCsLPS8w8WYKSV9oWDb054rKJnqne49lOcwARQuPeKmco");
            corecontacts.setNativeMiddleName("tVvv4BGfnDlqautTtfbUsA5MVzQ7a9fN10a6ThoOO5LaASYLqR");
            corecontacts.setNativeTitle("bhGr97xi4qsPSPuv1v8sGF8UGHI3J9MPlewUokq07wEgsEsInN");
            corecontacts.setPhoneNumber("V5uSLkB23q6D7Bx3SY9J");
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
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
