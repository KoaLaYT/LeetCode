add_library("20210907_Unique_Paths" solution.cpp)

add_executable("20210907_Unique_Paths_Test" solution_test.cpp)
target_link_libraries("20210907_Unique_Paths_Test" PRIVATE "20210907_Unique_Paths" GTest::gtest GTest::gtest_main)