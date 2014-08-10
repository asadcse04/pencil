
package com.pencil.InstituteSetup;

import java.util.List;

/**
 *
 * @author Mastermind
 */
public interface InstituteSetupService 
{
    public boolean saveInstitute(InstituteSetup instituteSetup);
    
    public boolean updateInstitute(InstituteSetup instituteSetupObj);
    
    public List<InstituteSetup> instituteSetupList();
}
