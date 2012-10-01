package org.multibit.mbm.db.dao.hibernate;

import com.google.common.base.Optional;
import org.multibit.mbm.db.dao.RoleDao;
import org.multibit.mbm.db.dto.Authority;
import org.multibit.mbm.db.dto.Role;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("hibernateRoleDao")
public class HibernateRoleDao extends BaseHibernateDao implements RoleDao {

  @Resource(name = "hibernateTemplate")
  private HibernateTemplate hibernateTemplate = null;

  @Override
  public Optional<Role> getRoleByAuthority(Authority authority) {
    return getRoleByName(authority.name());
  }

  @Override
  public Optional<Role> getRoleByName(String name) {
    List roles = hibernateTemplate.find("from Role r where r.name = ?", name);

    return first(roles, Role.class);
  }

  @Override
  public Role saveOrUpdate(Role role) {
    hibernateTemplate.saveOrUpdate(role);
    return role;
  }

  /**
   * Force an immediate in-transaction flush (normally only used in test code)
   */
  public void flush() {
    hibernateTemplate.flush();
  }


  public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
    this.hibernateTemplate = hibernateTemplate;
  }
}
