package project.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project.app.server.repository.AddressRepository;
import project.app.shared.location.Address;
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
import project.app.shared.location.AddressType;
import project.app.server.repository.AddressTypeRepository;
import project.app.shared.location.City;
import project.app.server.repository.CityRepository;
import project.app.shared.location.Country;
import project.app.server.repository.CountryRepository;
import project.app.shared.location.State;
import project.app.server.repository.StateRepository;

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
            addresstype.setAddressType("NzEkx2ha7iSxtAYqPVWJsvojxzSzG0RJqzu2HAQzaQGrhruMez");
            addresstype.setAddressTypeDesc("y1ipERLLHAeL2lt3FhmWbXkvA7RQBH2TuZPBpnK46P8IMtguYZ");
            addresstype.setAddressTypeIcon("zn6EA353nWPXHcdOhMsLbhvZPIPSBiOTdie8q18scv9bFBTH4G");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("ve6RbmbpIdGOAowKU4rJBvpdmsPtgyvX");
            city.setCityDescription("zTCstX5R6JBdg1BG2nCcrMF0Ba225pdk4F8nTZxQDaBtCKwsIJ");
            city.setCityFlag("vJNcTGl1qH5BlHCGWpBS4jV4QTDzEnygvwBAgtxN2zySSgo5td");
            city.setCityLatitude(9);
            city.setCityLongitude(0);
            city.setCityName("yHsWorLrex9x5ktSfGHGqaqzliZH0taS9x0SHAmKF2kykTdA2n");
            Country country = new Country();
            country.setCapital("T08LtCcuypGRbgDxbG65iyCNOX8Gg1RB");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(1);
            country.setCountryCode1("T79");
            country.setCountryCode2("DmU");
            country.setCountryFlag("7S81JDXN1gSRjbyB3r9gusadG5HqyoKYuNVt8PD7w3eN6L65uM");
            country.setCountryName("XumKS8euwtYOvQM7tFMsHDSqFNuXV6hyvDyLP4rPBVVpwqflSX");
            country.setCurrencyCode("yBI");
            country.setCurrencyName("oQhsBvLvf3J7OzEphNLTZhP5jeo2RDeaRQmIIxl8oUftGPlopB");
            country.setCurrencySymbol("7KP5CnMLhUleFUPE4dlFn1swtiuHg8Hd");
            country.setIsoNumeric(4);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("aaWXsq9bLMLut6DB3wuYuG3EnJfPMovG72bM8GecHt5mjwlf05");
            state.setStateCapitalLatitude(4);
            state.setStateCapitalLongitude(11);
            state.setStateCode(0);
            state.setStateCodeChar2("ceeKDs3Qz6BJbMT75xSYl6lItZPbTRKB");
            state.setStateCodeChar3("ObT0KnnSAulTI6WlykKrIbaJ1MgBOHf9");
            state.setStateDescription("DOnSWLQFfi6fKWRVWeBdcTby788RxEIBjJgcTKS2hkc32SZblX");
            state.setStateFlag("fKp0Hsjsavy6t7matEJOSwFDzpyk8PAIHb34tSWeQxGvoWw8GH");
            state.setStateName("R1xF4ehq0uPtD4mCvzVkuV1RGTt7MHLoCQOucstysknFmoukd1");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("iDL7woTDHyfyXTYIIEBHwa0YWDBSxXd8");
            city.setCityDescription("k2dMf4UWWFbwMUqJpdIw7clJeHoRducERCqNbmsONRmMPIclQg");
            city.setCityFlag("uE9jwCDwxZDnYhEePFjRiMsIN5CYw1sJcJYrl88X9OdHpvecG8");
            city.setCityLatitude(11);
            city.setCityLongitude(11);
            city.setCityName("7GruanvrgBQf2PHjYpzSs2LihirNUBxtxEFTLtGakSrdJI4Nh4");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("lglusXqwJixvAhACOni8xhU9n3ZSB409pdIqlD6qB67owo4VXF");
            address.setAddress2("Sb1vMMQAkKD62zymz5LBvwMgyJm8v2MAGho2GwK6aXpgd9T2jV");
            address.setAddress3("RU9INQ2xfIzi9RXT3gu6ziQfgb4tL92vCPwoaDvgSIhQ5RiBgu");
            address.setAddressLabel("q4hYRd9wZP9");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("qLVXEPXWMSsQ6LghGlcqhmUOPxcDXDosvgqbTe9YYM67xkdv7K");
            address.setLongitude("fnRKpeKQyyUt67VV6Lqt25fP5rAVEsg0TewsPSdRZAjPrIHsta");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("mB05Q0");
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
            address.setAddress1("mAGXyyFs1XYudo7LIJ4GrAr88TTj6ccs2XrTVMewiVy8RUYYJK");
            address.setAddress2("H8kbmK6jVvE7WvapZJaGlBwQ0Zxif8K9yvLUxyMXczQ1PRQ5Ll");
            address.setAddress3("2Ljk27EiWOxigXTWRRDz3gaaBEtxDEwma8WzXic2WDzHo4oDuV");
            address.setAddressLabel("VwxTDGXT383");
            address.setLatitude("1Unof8tbwXBnHMPvfU1kdwd2jLhEyoQBlgKIJLCB7LcbvYYUMZ");
            address.setLongitude("WvzcsRRBkQkvuSViBQZ3g2mBATqERvGHWvJKgOidd0PzhEoukV");
            address.setVersionId(1);
            address.setZipcode("75XMr7");
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
