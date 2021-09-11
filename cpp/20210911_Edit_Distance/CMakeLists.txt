add_library("20210911_Edit_Distance" solution.cpp)

add_executable("20210911_Edit_Distance_Test" solution_test.cpp)
target_link_libraries("20210911_Edit_Distance_Test" PRIVATE "20210911_Edit_Distance" GTest::gtest GTest::gtest_main)