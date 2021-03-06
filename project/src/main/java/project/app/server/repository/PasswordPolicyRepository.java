package project.app.server.repository;
import com.athena.server.repository.SearchInterface;
import com.spartan.shield.server.authentication.interfaces.PasswordPolicyRepositoryInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "puja.singh@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for PasswordPolicy Master table Entity", complexity = Complexity.LOW)
public interface PasswordPolicyRepository<T> extends SearchInterface, PasswordPolicyRepositoryInterface {

    public T save(T entity) throws SpartanPersistenceException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanConstraintViolationException, SpartanPersistenceException;

    public void update(List<T> entity) throws SpartanPersistenceException;

    public T findById(String policyId) throws Exception, SpartanPersistenceException;
}
