add_library("20210902_Jump" solution.cpp)

add_executable("20210902_Jump_Test" solution_test.cpp)
target_link_libraries("20210902_Jump_Test" PRIVATE "20210902_Jump" GTest::gtest GTest::gtest_main)