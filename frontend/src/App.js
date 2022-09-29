import * as React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

// import Main from "./pages/home/Home";
import TailwindHome from "./pages/tailwind-home/TailwindHome";
import TailwindPieces from "./pages/tailwind-pieces/TailwindPieces";
import TailwindPieceDetail from "./pages/tailwind-piecedetail/TailwindPieceDetail";
import LogIn from "./pages/login/LogIn";
import SignUp from "./pages/signup/SignUp";
import MyPage from "./pages/mypage/MyPage";
import UserModify from "./pages/usermodify/UserModify";
import Pieces from "./pages/pieces/Pieces";
import Help from "./pages/help/Help";
import Filter from "./pages/filter/Filter";
import PieceDetail from "./pages/piecedetail/PieceDetail";

import TailwindMyPage from "./pages/tailwind-mypage/TailwindMyPage";

import GlobalStyle from "./GlobalStyle";
import PieceCommit from "./pages/piececommit/PieceCommit";
import StyleTransfer from "./pages/styletransfer/StyleTransfer";
import Scent from "./pages/scent/Scent";

const router = createBrowserRouter([
  {
    path: "/",
    // element: <Main />,
    element: <TailwindHome />,
  },
  {
    path: "/login",
    element: <LogIn />,
  },
  {
    path: "/signup",
    element: <SignUp />,
  },
  {
    path: "/usermodify",
    element: <UserModify />,
  },
  {
    // path: "/mypage",
    path: "/mypage/:targetUserSeq",
    // element: <MyPage />,
    element: <TailwindMyPage />,
  },
  {
    path: "/pieces",
    // element: <Pieces />,
    element: <TailwindPieces />,
  },
  // {
  //   path: "/piece/:pieceSeq",
  //   element: <PieceDetail />,
  // },
  {
    path: "/pieces/:pieceSeq",
    element: <TailwindPieceDetail />,
  },
  {
    path: "/filter",
    element: <Filter />,
  },
  {
    path: "/help",
    element: <Help />,
  },
  {
    path: "/register",
    element: <PieceCommit />,
  },
  {
    path: "/styletransfer",
    element: <StyleTransfer />,
  },
  {
    path: "/scent",
    element: <Scent />,
  },
]);

const App = () => {
  return (
    <React.Fragment>
      <GlobalStyle />
      <RouterProvider router={router} />
    </React.Fragment>
  );
};

export default App;
