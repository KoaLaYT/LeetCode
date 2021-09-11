#include "solution.hpp"
#include <deque>

namespace impl {

static void updateDirs(std::string&             dir,
                       std::deque<std::string>& dirs)
{
    if (dir == "..") {
        if (!dirs.empty()) {
            dirs.pop_back();
        }
    } else if (dir != "." && !dir.empty()) {
        dirs.push_back(dir);
    }
    dir.clear();
}

};  // namespace impl

std::string Solution::simplifyPath(std::string path)
{
    std::string             dir;
    std::deque<std::string> dirs;

    for (char c : path) {
        if (c == '/') {
            impl::updateDirs(dir, dirs);
        } else {
            dir.push_back(c);
        }
    }

    if (dir.length() > 0) {
        impl::updateDirs(dir, dirs);
    }

    for (std::string d : dirs) {
        dir.append("/");
        dir.append(d);
    }

    if (dir.empty()) {
        dir.push_back('/');
    }

    return dir;
}