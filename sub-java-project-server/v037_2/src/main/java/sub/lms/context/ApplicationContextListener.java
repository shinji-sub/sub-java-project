package sub.lms.context;

import java.util.Map;

public interface ApplicationContextListener {

  void contextInitialized(Map<String, Object> context);

  void contextDestroyed(Map<String, Object> context);
}
