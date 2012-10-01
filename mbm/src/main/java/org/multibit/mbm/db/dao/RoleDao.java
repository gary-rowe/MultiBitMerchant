package org.multibit.mbm.db.dao;

import com.google.common.base.Optional;
import org.multibit.mbm.db.dto.Authority;
import org.multibit.mbm.db.dto.Role;

public interface RoleDao {

  /**
   * Attempt to locate the Role using a shortcut Authority
   *
   * @param authority The Role shortcut Authority  (e.g. "ROLE_CUSTOMER")
   * @return A matching Role
   * @throws RoleNotFoundException If something goes wrong
   */
  Optional<Role> getRoleByAuthority(Authority authority) throws RoleNotFoundException;

  /**
   * Attempt to locate the Role using a name
   *
   * @param name The Role name (e.g. "ROLE_SPECIAL") which has been defined by an admin
   * @return A matching Role
   * @throws RoleNotFoundException If something goes wrong
   */
  Optional<Role> getRoleByName(String name);

  /**
   * Persist the given Role
   * @param Role A Role (either new or updated)
   * @return The persisted Role
   */
  Role saveOrUpdate(Role Role);

  /**
   * <p>Force an immediate in-transaction flush</p>
   * <p>Normally, this is only used in test code but must be on the interface to ensure
   * that injection works as expected</p>
   */
  void flush();

}
