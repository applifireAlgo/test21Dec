package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
            addresstype.setAddressType("CIv4OfZYP1BMzcWpaxzbdb7WvXtYwaWpmlbAe04PmqcODo9sTd");
            addresstype.setAddressTypeDesc("elmdmaYChVf2TgSZQl6AwlZ83xMzyCPzHuywtOCh6SSYo0ehb0");
            addresstype.setAddressTypeIcon("3RgGV6fQexp0gNQMZYCotoDfvNBDJWrSR3W1l24czspmoGTlh0");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("vEvyn9Kz07RUWxI51FKkdxa4brlZPflV");
            city.setCityDescription("roRve4lJwwlDi7OetCye2FLjIxyXbThqxycL6DpTMFj1TFzCHA");
            city.setCityFlag("2L9Q5vjqv6vTOeDVVkciIg7vDYtGDmHRxD7i0qKyOPBQLntGmI");
            city.setCityLatitude(8);
            city.setCityLongitude(3);
            city.setCityName("hCnmli5CFgia7AEJkUVU1uSwcurS2yDymJ7Te3GlgXpBprnKhO");
            Country country = new Country();
            country.setCapital("3HYPg8f3U1nvVQYasRjjsMxjI79dnMp5");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(5);
            country.setCountryCode1("VXU");
            country.setCountryCode2("8oB");
            country.setCountryFlag("K6MemRbd4ChpK3DxjnNQMv3Sj66ZBS8tv6vUWDjA42jT54wxEA");
            country.setCountryName("GuzGuJ6qMomhb6BfvrFeIUmosHquSYubt5kYcmBNJqw9FTAstU");
            country.setCurrencyCode("INr");
            country.setCurrencyName("FtJfMmxl4TPPgUSeVK3mpr7ew9DI1zy010jJUqmu25ukCIAaua");
            country.setCurrencySymbol("29v0jZ7sAEIzLqfmbYVCWPTr1H7n9mir");
            country.setIsoNumeric(2);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("NqwUEPYFPxemI4nPee6BSyoVS7k6V1YFaHwxrk2wpdxdnwsaG1");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(7);
            state.setStateCode(1);
            state.setStateCodeChar2("qmesLX6SxlZplaBa5idJUOrVzrqXGk0b");
            state.setStateCodeChar3("1dnWLUb5gy903dGbRahBQlttO4spZiq8");
            state.setStateDescription("dq4XMjRsOaXYuf7LjFWakHdkrR2ZpsSkhFbU6TkExs9Gy7xWSE");
            state.setStateFlag("xfATJcT3uooeqSxEWWZU7sekDKNEMf9wquvbNAIxFbsJNurqOc");
            state.setStateName("CO2O8M5pQIG6ntjYBBQ6ED6JPC4vObVHjObJk7nfnYfWI7jXUg");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("4VljD6JWx8uKdy3bWMe5QsDTX3QXw3Q3");
            city.setCityDescription("cYZRewPW2V72mzyebjbO0Q8OwwVASI4M1QGBxg8oLjFVyUTPCz");
            city.setCityFlag("aWWOePpTomZPU1HC0HFy0Skjxk96jZJp5DWzGW1xN7h952gErT");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("ehVNX7pMbTKE7oVNsXF1ccyNQoGga8qMEjisCPzcv8JKvfcF88");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("rKhsNjNFsL3S8Qo5wFiUzi0O6fcIkNLQKWDkzUOIKNCllRxd81");
            address.setAddress2("NikDPQoNIwrZAEkW7Mp4cJhNSl9IVxhQ37Tw6w8UxYrC5FRELY");
            address.setAddress3("QvbCHoyworyWWvoxP7LzQuWVrx2APnvcS6ftYbXpXqHPl4XdJO");
            address.setAddressLabel("G6mcSnOfgWw");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("HSQRlNq5fBjKt2iewuXQpRzj0ZVp0eWhX0QSjSZ6bj4p68tfBb");
            address.setLongitude("YvLjv0zqryU3FCKgTV3y0wrj7ZLA7rny31oQSqQ4jCLCaj6a6C");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("T9eLcz");
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
            address.setAddress1("c4X0vSaSBids54QQEUCHEIeiBK5Luyj3Qe9cyZbHF19ridBlDZ");
            address.setAddress2("ek9P9nshGPvQkIc0idyg6NKgTdSJc0cJKDXXZulefFzgmEUoFw");
            address.setAddress3("AAmt3jqWig9Quc67RTmYyesTLMqzQnDV3Ce3MCYgutNY1vju50");
            address.setAddressLabel("b8D90ji5CoY");
            address.setLatitude("0RwFsZ9YuNHfgMdjt1gJL2QQ6By3qugellHcvfl0SF4jKNXpCi");
            address.setLongitude("ZHQmhmvny8QejXX5RylGuPXkM1e48wVJSqE5ryIUWj6QpnBGWx");
            address.setVersionId(1);
            address.setZipcode("Mg0Yim");
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
