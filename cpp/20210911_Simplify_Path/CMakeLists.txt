add_library("20210911_Simplify_Path" solution.cpp)

add_executable("20210911_Simplify_Path_Test" solution_test.cpp)
target_link_libraries("20210911_Simplify_Path_Test" PRIVATE "20210911_Simplify_Path" GTest::gtest GTest::gtest_main)