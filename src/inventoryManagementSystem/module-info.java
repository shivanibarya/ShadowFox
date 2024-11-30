/**
 * Module declaration for the ShadowFox project.
 */
module ShadowFox {
    // Require the JUnit module for unit testing
    requires org.junit.jupiter.api; // For JUnit 5 (Jupiter)
    requires org.junit.jupiter.engine; // Required for the JUnit 5 engine

    // Export your packages
    exports ContactManagementSystem; // Exporting ContactManagementSystem package
    exports calculator; // Exporting calculator package
}
