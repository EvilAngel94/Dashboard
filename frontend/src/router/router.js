import Vue from "vue";
import Router from "vue-router";
import Dashboard from "@/dashboard/Dashboard";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      name: "Dashboard",
      component: Dashboard
    },
    {
      path: "/interactable/:slug",
      name: "InteractableDetail",
      props: true,
      component: () => import( /* webpackChuckName: "InteractableDetail" */ "../interactable/view/InteractableDetail")
    }
  ]
});