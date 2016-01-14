package sales.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.AddressRepository;
import sales.app.shared.location.Address;
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
import sales.app.shared.location.AddressType;
import sales.app.server.repository.AddressTypeRepository;
import sales.app.shared.location.City;
import sales.app.server.repository.CityRepository;
import sales.app.shared.location.Country;
import sales.app.server.repository.CountryRepository;
import sales.app.shared.location.State;
import sales.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("Op9uw0khUTtokywV2WFKeCrPkzcyMuDrVKpQYgH23F84ISfZY2");
            addresstype.setAddressTypeDesc("QBS7pdtE5t2aUZ2J0rD0t3GqLThSCVyXpLYF5N584xx8JteZZe");
            addresstype.setAddressTypeIcon("KzHMC3B938gFnTbZ8y8XPZExTmI0ZAc6eGM8sOGSf2NLMohTIO");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("FEaJ6mD9geiF4BJrg04XltdFhJBRDX87");
            city.setCityDescription("6gDBBLxjT2fjQmZ6PWvNrmbBubQHImkmvD6S9up4m7GSO9jpXZ");
            city.setCityFlag("K3E7RP022Mprqnuce8iY6U9Dz8Pj2rKj0Nn1FN2c76m3BmeH0T");
            city.setCityLatitude(4);
            city.setCityLongitude(5);
            city.setCityName("R1DSSRssKAIZxYboVbMfr8syQNjJcjnKJG8bK3EPmtupZMO7y5");
            Country country = new Country();
            country.setCapital("psW8XbPydREO0dQLGzdEzaPLgZzCYU8L");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(9);
            country.setCountryCode1("B7p");
            country.setCountryCode2("eBS");
            country.setCountryFlag("oLl3Ang4cR6KKhWw3g1YH2JIWejR6Isa2SFDfAxSverKuZBD5m");
            country.setCountryName("ajte8AWhAURQCGCTTe6IFtERMdB1WxmeNBB8bUMGtRwkZgitGO");
            country.setCurrencyCode("1C3");
            country.setCurrencyName("58vEuIOmCpBIjae2GBfmmZTqpFnktJmJ0CgcqmTXXdrcr8DtB4");
            country.setCurrencySymbol("uHdg9r5i93cwGDd7kG0SpJ65gaOloMr8");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("PFHl4ejigI3QdgXduktfqL0z9VefQIZ0Y564US7KhSCUfi2xht");
            state.setStateCapitalLatitude(0);
            state.setStateCapitalLongitude(1);
            state.setStateCode(2);
            state.setStateCodeChar2("2dwBY6FoYD9tnLcIbEnZJ8caPC4lJAfT");
            state.setStateCodeChar3("8NhdqTD9GBWzWNsb23nlpZLhmbFumZr4");
            state.setStateDescription("GRxBOfxsbCm9K7hS9tXh0SJHuuAtJ960DAq3q9nn4rQv68nyPN");
            state.setStateFlag("3zZANJBrjESUOqlAqu0jlYaxdbp10WG6Z3hadtJgOymJrf5ouV");
            state.setStateName("ewcj15AadZgMA4fjJvkUZoDT15ysJHGmsZBAJnkK2ekHOIwq7G");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("UQHyqXydSHJAMkDx8BEMpvhmgvSZr0fk");
            city.setCityDescription("1YcXj69p4XDEaG4Dx5TWAehJPAq94RZuNUWHQVPGFLjf8e6ZFz");
            city.setCityFlag("I6ozYjv1FetlYcOUT4jau1kg2ZMQU8R9OC3VR4bEzavdFh4oIA");
            city.setCityLatitude(7);
            city.setCityLongitude(6);
            city.setCityName("CowHLyQAtRWr3qCYkFEwSZ9xMgXECeJjmUWwG9zIQYjB2WZI73");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("7HFeY8y5pNhPXYsEtaI1uzOZ4rV3LSLiG1Ynw9bybs63bJosfe");
            address.setAddress2("z4jivr7aO3YsQsipC0CDMLl1LJ1EZPDEjY2y2UIKAeWGWQfgSn");
            address.setAddress3("D6etlOrem5YH7mvatbJizY0XPhcZMkzR8V26Vg3r8d581GgSHN");
            address.setAddressLabel("GK83vIG3BMU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("CdHBCBOVK38fUVGJJW9qGFmjPCdSj1R3ZUq716tyl5ECP8MBRL");
            address.setLongitude("o8TkJ0cXWH4zzBzX6k1HUkyN467v7JZPybBR9N5ruJ00g54SGA");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("h6TaGV");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("e9cZgep9ztBY8q0BzDpdxP8vCJOhlU9qM2xFBddyI9tOyxTX2M");
            address.setAddress2("tbWkVVFyNt4CtXhTjYR7GHkD759VO0NUNE80HtM7LMJ6vaRwHU");
            address.setAddress3("O95IW74B08NJnrZqRPMmgAEWk8CIUG4NtrFowFPq2lv0p8sbTp");
            address.setAddressLabel("lMoLDOZlMe1");
            address.setLatitude("pgvMYoqhJGjjHXaCYgjvI4EBMOCnv3KfqLByVisxMZI2ELiUTr");
            address.setLongitude("XnpS9w0PAuVsLbgxgNJ3BBWJBvDVUAq0MEWgAeptvzGOWyvENH");
            address.setVersionId(1);
            address.setZipcode("hhoTb2");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
