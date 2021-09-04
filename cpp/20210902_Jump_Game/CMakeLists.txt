add_library("20210902_Jump_Game" solution.cpp)

add_executable("20210902_Jump_Game_Test" solution_test.cpp)
target_link_libraries("20210902_Jump_Game_Test" PRIVATE "20210902_Jump_Game" GTest::gtest GTest::gtest_main)